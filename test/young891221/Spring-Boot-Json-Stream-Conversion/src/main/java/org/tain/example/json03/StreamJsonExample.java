package org.tain.example.json03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.tain.example.info.FieldInfo;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "example.json03.StreamJsonExample")
public class StreamJsonExample {

	private static final boolean flag = true;
	
	@Autowired
	private StreamJsonProperty streamJsonProperty;
	
	private ObjectMapper objectMapper = null;
	private MastInfo mastInfo = null;
	private StoreInfo storeInfo = null;
	private Item01Info item01Info = null;
	private Item23Info item23Info = null;
	
	@Bean(value = "example.svr01.ServerExample.test01")
	public void test01() throws Exception {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + streamJsonProperty);
		}
		
		if (flag) {
			this.objectMapper = new ObjectMapper();  // create once, reuse
			this.mastInfo = this.objectMapper.readValue(ResourceUtils.getFile("classpath:templates/json/MastInfo.json"), MastInfo.class);
			this.storeInfo = this.objectMapper.readValue(ResourceUtils.getFile("classpath:templates/json/StoreInfo.json"), StoreInfo.class);
			this.item01Info = this.objectMapper.readValue(ResourceUtils.getFile("classpath:templates/json/Item01Info.json"), Item01Info.class);
			this.item23Info = this.objectMapper.readValue(ResourceUtils.getFile("classpath:templates/json/Item23Info.json"), Item23Info.class);
			//this.item23Info = this.objectMapper.readValue(ResourceUtils.getFile("file:templates/json/Item23Info.json"), Item23Info.class);
			//this.item23Info = this.objectMapper.readValue(ResourceUtils.getFile("templates/json/Item23Info.json"), Item23Info.class);
		}

		if (flag) {
			File file = ResourceUtils.getFile("classpath:templates/data/Request01(Euckr).dat");
			System.out.println(">>>>> file: " + file.getAbsolutePath());
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ResourceUtils.getFile("classpath:templates/data/Request01(Euckr).dat")), "EUC-KR"));
			String line;
			
			ObjectMapper objectMapper = new ObjectMapper();  // create once, reuse

			while ((line = bufferedReader.readLine()) != null) {
				if (flag) System.out.println(">>>>> " + line);
				analyze(line, objectMapper);
			}
			
			bufferedReader.close();
		}
	}
	
	private void analyze(String strReq, ObjectMapper objectMapper) throws Exception {
		strReq = strReq.replace('.', ' ');
		byte[] byteReq = strReq.getBytes("EUC-KR");
		int offset = 0;
		
		// MastInfo
		System.out.println("########## MastInfo: " + this.mastInfo);
		for (FieldInfo fieldInfo : this.mastInfo.getFields()) {
			String strField = new String(byteReq, offset, fieldInfo.getLength(), "EUC-KR");
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
			String strField = new String(byteReq, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();
			
			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));

			String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
			System.out.println(">>>>> " + jsonString);
		}
		
		for (; offset < byteReq.length;) {
			String id = new String(byteReq, offset, 2, "EUC-KR");
			
			if ("01".equals(id)) {
				// Item01Info
				System.out.println("########## Item01Info: " + this.item01Info);
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					String strField = new String(byteReq, offset, fieldInfo.getLength(), "EUC-KR");
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
					String strField = new String(byteReq, offset, fieldInfo.getLength(), "EUC-KR");
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




