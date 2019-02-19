package org.tain.fep.stream2json;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.fep.info.FieldInfo;
import org.tain.fep.info.Item01Info;
import org.tain.fep.info.Item23Info;
import org.tain.fep.info.MastInfo;
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
			this.mastInfo = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("MastInfo"), MastInfo.class);
			this.storeInfo = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("StoreInfo"), StoreInfo.class);
			this.item01Info = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("Item01Info"), Item01Info.class);
			this.item23Info = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("Item23Info"), Item23Info.class);
			
			analyze(stream);
		}
	}
	
	//////////////////////////////////////////////////
	
	private ObjectMapper objectMapper = null;
	private MastInfo mastInfo = null;
	private StoreInfo storeInfo = null;
	private Item01Info item01Info = null;
	private Item23Info item23Info = null;

	private void analyze(String stream) throws Exception {
		stream = stream.replace('.', ' ');
		byte[] bytData = stream.getBytes("EUC-KR");
		int offset = 0;

		// MastInfo
		System.out.println("########## MastInfo: " + this.mastInfo);
		for (FieldInfo fieldInfo : this.mastInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();
			
			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));

			String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
			System.out.println(">>>>> " + jsonString);
		}

		// StoreInfo
		System.out.println("########## StoreInfo: " + this.storeInfo);
		for (FieldInfo fieldInfo : this.storeInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();
			
			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));

			String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
			System.out.println(">>>>> " + jsonString);
		}
		
		for (; offset < bytData.length;) {
			String id = new String(bytData, offset, 2, "EUC-KR");
			
			if ("01".equals(id)) {
				// Item01Info
				System.out.println("########## Item01Info: " + this.item01Info);
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					offset += fieldInfo.getLength();
					
					// 필드 원본값 저장
					fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(getToValue(fieldInfo));

					String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					System.out.println(">>>>> " + jsonString);
				}
			} else if ("23".equals(id)) {
				// Item23Info
				System.out.println("########## Item23Info: " + this.item23Info);
				for (FieldInfo fieldInfo : item23Info.getFields()) {
					String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					offset += fieldInfo.getLength();
					
					// 필드 원본값 저장
					fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(getToValue(fieldInfo));

					String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					System.out.println(">>>>> " + jsonString);
				}
			}
		}
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
