package org.tain.fep.stream2json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.fep.info.FieldInfo;
import org.tain.fep.info.Item01Info;
import org.tain.fep.info.Item23Info;
import org.tain.fep.info.MastInfo;
import org.tain.fep.info.ReqDataInfo;
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
		
		String stream1 = null;
		ReqFieldInfo reqFieldInfo1 = null;
		ReqDataInfo reqDataInfo = null;
		ReqFieldInfo reqFieldInfo2 = null;
		String stream2 = null;
		
		if (flag) {
			// get stream
			stream1 = HttpClientResponse.getInstance().getReqStram(2).replace('.', ' ');
			if (flag) System.out.println(">>>>> stream1: [" + stream1 + "]");
		}
		
		if (flag) {
			// get field info
			this.objectMapper = new ObjectMapper();  // need one instance
			reqFieldInfo1 = analyze(stream1);
			if (!flag) System.out.println(">>>>> " + reqFieldInfo1);
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo1));  // 이쁜 출력
		}
		
		if (!flag) {
			// check print
			if (!flag) for (FieldInfo fieldInfo : reqFieldInfo1.getStoreInfo().getFields()) {
				if (flag) System.out.println(">>>>>" + fieldInfo);
			}
			
			if (flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo1.getMastInfo()));  // 이쁜 출력
			if (flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo1.getStoreInfo()));  // 이쁜 출력
			if (flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo1.getListItem01Info()));  // 이쁜 출력
			if (flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo1.getItem23Info()));  // 이쁜 출력
		}
		
		if (flag) {
			// json -> map (reqDataInfo)
			reqDataInfo = new ReqDataInfo();
			
			if (flag) {
				Map<String, String> map = new HashMap<>();
				for (FieldInfo fieldInfo : reqFieldInfo1.getMastInfo().getFields()) {
					if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldId(), fieldInfo.getToValue());
					map.put(fieldInfo.getFieldId(), fieldInfo.getToValue());
				}
				reqDataInfo.setMastData(map);
			}
			
			if (flag) {
				Map<String, String> map = new HashMap<>();
				for (FieldInfo fieldInfo : reqFieldInfo1.getStoreInfo().getFields()) {
					if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldId(), fieldInfo.getToValue());
					map.put(fieldInfo.getFieldId(), fieldInfo.getToValue());
				}
				reqDataInfo.setStoreData(map);
			}
			
			if (flag) {
				List<Map<String, String>> listMap = new ArrayList<>();
				for (Item01Info item01Info : reqFieldInfo1.getListItem01Info()) {
					Map<String, String> map = new HashMap<>();
					for (FieldInfo fieldInfo : item01Info.getFields()) {
						if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldId(), fieldInfo.getToValue());
						map.put(fieldInfo.getFieldId(), fieldInfo.getToValue());
					}
					listMap.add(map);
				}
				reqDataInfo.setListItem01Data(listMap);
			}
			
			if (flag) {
				Map<String, String> map = new HashMap<>();
				for (FieldInfo fieldInfo : reqFieldInfo1.getItem23Info().getFields()) {
					if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldId(), fieldInfo.getToValue());
					map.put(fieldInfo.getFieldId(), fieldInfo.getToValue());
				}
				reqDataInfo.setItem23Data(map);
			}
			
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqDataInfo));  // 이쁜 출력
		}
		
		if (flag) {
			// reqFieldInfo2
			reqFieldInfo2 = new ReqFieldInfo();
			
			if (flag) {
				// MastInfo
				Map<String, String> map = reqDataInfo.getMastData();
				MastInfo mastInfo = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("MastInfo"), MastInfo.class);
				if (!flag) System.out.println("########## MastInfo: " + mastInfo);
				for (FieldInfo fieldInfo : mastInfo.getFields()) {
					//String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					//offset += fieldInfo.getLength();
					
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(map.get(fieldInfo.getFieldId()));
					// 필드 원본값 저장
					fieldInfo.setFromValue(getFromValue(fieldInfo));

					//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					//System.out.println(">>>>> " + jsonString);
				}
				if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mastInfo));  // 이쁜 출력
				
				reqFieldInfo2.setMastInfo(mastInfo);
			}
			
			if (flag) {
				// StoreInfo
				Map<String, String> map = reqDataInfo.getStoreData();
				StoreInfo storeInfo = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("StoreInfo"), StoreInfo.class);
				if (!flag) System.out.println("########## StoreInfo: " + storeInfo);
				for (FieldInfo fieldInfo : storeInfo.getFields()) {
					//String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					//offset += fieldInfo.getLength();
					
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(map.get(fieldInfo.getFieldId()));
					// 필드 원본값 저장
					fieldInfo.setFromValue(getFromValue(fieldInfo));

					//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					//System.out.println(">>>>> " + jsonString);
				}
				if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(storeInfo));  // 이쁜 출력
				
				reqFieldInfo2.setStoreInfo(storeInfo);
			}
			
			if (flag) {
				// Item01Info
				List<Item01Info> listItem01Info = new ArrayList<>();
				for (Map<String, String> map : reqDataInfo.getListItem01Data()) {
					Item01Info item01Info = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("Item01Info"), Item01Info.class);
					if (!flag) System.out.println("########## Item23Info: " + item01Info);
					for (FieldInfo fieldInfo : item01Info.getFields()) {
						//String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
						//offset += fieldInfo.getLength();
						
						// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
						fieldInfo.setToValue(map.get(fieldInfo.getFieldId()));
						// 필드 원본값 저장
						fieldInfo.setFromValue(getFromValue(fieldInfo));

						//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
						//System.out.println(">>>>> " + jsonString);
					}
					if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item01Info));  // 이쁜 출력
					
					listItem01Info.add(item01Info);
				}
				reqFieldInfo2.setListItem01Info(listItem01Info);
			}
			
			if (flag) {
				// Item23Info
				Map<String, String> map = reqDataInfo.getItem23Data();
				Item23Info item23Info = this.objectMapper.readValue(HttpClientResponse.getInstance().getFieldInfo("Item23Info"), Item23Info.class);
				if (!flag) System.out.println("########## Item23Info: " + item23Info);
				for (FieldInfo fieldInfo : item23Info.getFields()) {
					//String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					//offset += fieldInfo.getLength();
					
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(map.get(fieldInfo.getFieldId()));
					// 필드 원본값 저장
					fieldInfo.setFromValue(getFromValue(fieldInfo));

					//String jsonString = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldInfo);  // 이쁜 출력
					//System.out.println(">>>>> " + jsonString);
				}
				if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item23Info));  // 이쁜 출력
				
				reqFieldInfo2.setItem23Info(item23Info);
			}
			
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo2));  // 이쁜 출력)
		}
		
		
		if (flag) {
			// to stream data
			StringBuffer sb = new StringBuffer();
			
			for (FieldInfo fieldInfo : reqFieldInfo2.getMastInfo().getFields()) {
				sb.append(fieldInfo.getFromValue());
			}
			
			for (FieldInfo fieldInfo : reqFieldInfo2.getStoreInfo().getFields()) {
				sb.append(fieldInfo.getFromValue());
			}
			
			for (Item01Info item01Info : reqFieldInfo2.getListItem01Info()) {
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					sb.append(fieldInfo.getFromValue());
				}
			}
			
			for (FieldInfo fieldInfo : reqFieldInfo2.getItem23Info().getFields()) {
				sb.append(fieldInfo.getFromValue());
			}
			
			stream2 = sb.toString();
		}
		
		if (flag) {
			// compare before and after
			if (flag) System.out.println(">>>>> stream1: [" + stream1 + "]");
			if (flag) System.out.println(">>>>> stream2: [" + stream2 + "]");
			
			if (stream1.equals(stream2)) {
				System.out.println("result: equals...");
			} else {
				System.out.println("result: not equals...");
			}
		}
	}
	
	//////////////////////////////////////////////////
	
	private ObjectMapper objectMapper = null;
	
	private ReqFieldInfo analyze(String stream) throws Exception {
		// stream = stream.replace('.', ' ');
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
	
	private String getFromValue(FieldInfo fieldInfo) throws Exception {
		String ret = null;
		
		if (!flag) {
			String string = String.format("%-" + String.format("%d.%d", 10, 10)+ "s", flag ? "abcd" : "abcdefghijklmn");
			System.out.printf(">>>>>>>>>> [%s]%n", string);
			System.out.printf(">>>>>>>>>> [%020d]%n", 1234567890123L);
			System.out.printf(">>>>>>>>>> [%010d]%n", 1234567);
		}
		
		if (!flag) {
			byte[] byt1 = "한글입니다.".getBytes("EUC-KR");
			byte[] byt2 = new byte[1024];
			Arrays.fill(byt2, (byte) ' ');
			System.arraycopy(byt1, 0, byt2, 0, byt1.length);
			ret = new String(byt2, 0, 20, "EUC-KR");
			System.out.println(">>>>> [" + ret + "]");
		}

		String toValue = fieldInfo.getToValue();
		String fieldType = fieldInfo.getFieldType();
		int len = fieldInfo.getLength();

		if ("STRING".equals(fieldType) || "".equals(toValue)) {
			if (!flag) {
				// sample
				ret = String.format("%-" + String.format("%d.%d", len, len) + "s", toValue);  // print string length. if 한글, error
			} else if (!flag) {
				// sample
				byte[] byt1 = toValue.getBytes("EUC-KR");
				int length = byt1.length;
				byte[] byt2 = Arrays.copyOf(byt1, len);
				for (int i=length; i < len; i++) {
					byt2[i] = ' ';
				}
				ret = new String(byt2, "EUC-KR");
			} else if (flag) {
				// correct
				byte[] byt1 = toValue.getBytes("EUC-KR");
				byte[] byt2 = new byte[1024];
				Arrays.fill(byt2, (byte) ' ');
				System.arraycopy(byt1, 0, byt2, 0, byt1.length);
				ret = new String(byt2, 0, len, "EUC-KR");
			}
		} else if ("LONG".equals(fieldType)) {
			ret = String.format("%" + String.format("0%d", len) + "d", Long.parseLong(toValue));
		} else if ("INTEGER".equals(fieldType)) {
			ret = String.format("%" + String.format("0%d", len) + "d", Integer.parseInt(toValue));
		} else if ("DATE".equals(fieldType)) {
			ret = toValue.replace("/", "");
		} else if ("TIME".equals(fieldType)) {
			ret = toValue.replace(":", "");
		} else {
			throw new Exception(String.format("ERROR: wrong FieldType '%s'..... in DocInfo.", fieldType));
		}
		
		return ret;
	}
}
