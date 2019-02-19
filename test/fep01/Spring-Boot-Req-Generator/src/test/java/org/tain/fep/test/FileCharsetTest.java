package org.tain.fep.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.tain.utils.ClassUtil;

public class FileCharsetTest {

	private static final boolean flag = true;
	
	private static final String FILE_PATH = "templates/data/Request01(Euckr).dat";
	
	public void test01() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) {
			Resource resource = new ClassPathResource(FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "EUC-KR"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(">>>>> " + line);
			}
			bufferedReader.close();
		}
		
		if (flag) {
			/*
			Resource resource = new ClassPathResource(FILE_PATH);
			List<String> list = Files.readLines(resource.getFile(), Charset("UTF-8"));
			
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "EUC-KR"));
			bufferedReader.lines().collect(collector)
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(">>>>> " + line);
			}
			bufferedReader.close();
			*/
		}
		
		if (flag) {
			/*
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
			*/
		}

		
		if (flag) {
			/*
			ObjectMapper objectMapper = new ObjectMapper();
			// MastInfo mastInfo = objectMapper.readValue(ResourceUtils.getFile("classpath:templates/json/MastInfo.json"), MastInfo.class);  // ERROR on Executable JAR
			MastInfo mastInfo = objectMapper.readValue(new ClassPathResourceReader("templates/json/MastInfo.json").getContent(), MastInfo.class);
			// MastInfo
			if (flag) {
				System.out.println("########## MastInfo: " + mastInfo);
				String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mastInfo);  // 이쁜 출력
				System.out.println(">>>>> " + jsonString);
			} else {
				System.out.println("########## MastInfo FieldIfo ##########");
				for (FieldInfo fieldInfo : mastInfo.getFields()) {
					//String strField = new String(byteReq, offset, fieldInfo.getLength(), "EUC-KR");
					//offset += fieldInfo.getLength();
					
					// 필드 원본값 저장
					//fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					//fieldInfo.setToValue(getToValue(fieldInfo));

					String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					System.out.println(">>>>> " + jsonString);
				}
			}
			*/
		}
	}
	
	/*
	@SuppressWarnings("unused")
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
	*/
}
