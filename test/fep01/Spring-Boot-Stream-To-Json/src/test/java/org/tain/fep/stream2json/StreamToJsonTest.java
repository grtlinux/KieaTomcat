package org.tain.fep.stream2json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.fep.info.FieldInfo;
import org.tain.fep.info.Item01Info;
import org.tain.fep.info.Item23Info;
import org.tain.fep.info.MastInfo;
import org.tain.fep.info.ReqFieldInfo;
import org.tain.fep.info.StoreInfo;
import org.tain.utils.ClassUtil;
import org.tain.utils.HttpClientResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "fep.stream2json.StreamToJson")
public class StreamToJsonTest {

	private static final boolean flag = true;
	
	@Bean(value = "fep.stream2json.StreamToJson.test01")
	public void test01() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		String stream = null;
		
		if (flag) {
			// get stream
			stream = HttpClientResponse.getInstance().getReqStram(0);
			if (flag) System.out.println(">>>>> STREAM: " + stream);
		}
		
		if (flag) {
			// get field info
			this.objectMapper = new ObjectMapper();  // need one instance
			ReqFieldInfo reqFieldInfo = analyze(stream);
			if (!flag) System.out.println(">>>>> " + reqFieldInfo);
			if (flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo));  // 이쁜 출력

			if (!flag) for (FieldInfo fieldInfo : reqFieldInfo.getStoreInfo().getFields()) {
				if (flag) System.out.println(">>>>>" + fieldInfo);
			}
		}
	}
	
	//////////////////////////////////////////////////
	
	private ObjectMapper objectMapper = null;
	
	private ReqFieldInfo analyze(String stream) throws Exception {
		stream = stream.replace('.', ' ');
		byte[] bytData = stream.getBytes("EUC-KR");
		int offset = 0;

		// Request Field Info
		ReqFieldInfo reqFieldInfo = new ReqFieldInfo();
		
		// MastInfo
		MastInfo mastInfo = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("MastInfo"), MastInfo.class);
		if (!flag) System.out.println("########## MastInfo: " + mastInfo);
		for (FieldInfo fieldInfo : mastInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();
			
			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));

			//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
			//System.out.println(">>>>> " + jsonString);
		}
		reqFieldInfo.setMastInfo(mastInfo);
		

		// StoreInfo
		StoreInfo storeInfo = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("StoreInfo"), StoreInfo.class);
		if (!flag) System.out.println("########## StoreInfo: " + storeInfo);
		for (FieldInfo fieldInfo : storeInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();
			
			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));

			//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
			//System.out.println(">>>>> " + jsonString);
		}
		reqFieldInfo.setStoreInfo(storeInfo);
		
		List<Item01Info> listItem01Info = new ArrayList<>();
		
		for (; offset < bytData.length;) {
			String id = new String(bytData, offset, 2, "EUC-KR");
			
			if ("01".equals(id)) {
				// Item01Info
				Item01Info item01Info = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("Item01Info"), Item01Info.class);
				if (!flag) System.out.println("########## Item01Info: " + item01Info);
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					offset += fieldInfo.getLength();
					
					// 필드 원본값 저장
					fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(getToValue(fieldInfo));

					//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					//System.out.println(">>>>> " + jsonString);
				}
				listItem01Info.add(item01Info);
				
			} else if ("23".equals(id)) {
				// Item23Info
				Item23Info item23Info = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("Item23Info"), Item23Info.class);
				if (!flag) System.out.println("########## Item23Info: " + item23Info);
				for (FieldInfo fieldInfo : item23Info.getFields()) {
					String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					offset += fieldInfo.getLength();
					
					// 필드 원본값 저장
					fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(getToValue(fieldInfo));

					//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					//System.out.println(">>>>> " + jsonString);
				}
				reqFieldInfo.setItem23Info(item23Info);
			}
		}
		reqFieldInfo.setListItem01Info(listItem01Info);
		
		return reqFieldInfo;
	}
	
	private String getToValue(FieldInfo fieldInfo) throws Exception {
		
		String ret = null;
		
		String fromValue = fieldInfo.getFromValue();
		String fieldType = fieldInfo.getFieldType();
		
		if (!fieldType.equals("STRING") && fromValue.trim().length() > 0) {
			if (fieldType.equals("LONG")) {
				ret = String.format("%d", Long.parseLong(fromValue));
			} else if (fieldType.equals("INTEGER")) {
				ret = String.format("%d", Integer.parseInt(fromValue));
			} else if (fieldType.equals("DATE")) {
				ret = fromValue.substring(0, 4) + "/" + fromValue.substring(4, 6) + "/" + fromValue.substring(6, 8);
			} else if (fieldType.equals("TIME")) {
				ret = fromValue.substring(0, 2) + ":" + fromValue.substring(2, 4) + ":" + fromValue.substring(4, 6);
			} else {
				throw new Exception(String.format("ERROR: wrong FieldType '%s'..... in DocInfo.", fieldType));
			}
		} else {
			ret = fromValue.trim();  // string은 공백 삭제ㅠ
		}

		return ret;
	}
}
