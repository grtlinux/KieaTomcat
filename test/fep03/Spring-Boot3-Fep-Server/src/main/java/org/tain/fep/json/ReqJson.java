package org.tain.fep.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tain.fep.info.FieldInfo;
import org.tain.fep.info.Item01Info;
import org.tain.fep.info.Item23Info;
import org.tain.fep.info.MastInfo;
import org.tain.fep.info.ReqDataInfo;
import org.tain.fep.info.ReqFieldInfo;
import org.tain.fep.info.ResFieldInfo;
import org.tain.fep.info.StoreInfo;
import org.tain.fep.property.Property;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReqJson {

	private static final boolean flag = true;
	
	private ObjectMapper objectMapper = null;
	private Map<String, Object> mapInfo = new HashMap<>();
	private Property property;
	
	private ReqJson(Property property) throws Exception {
		this.property = property;
		
		if(flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if(flag) System.out.println(">>>>> ReqJson.Property -> " + this.property);
		
		if (flag) {
			this.objectMapper = new ObjectMapper();

			String content;
			String infoPath = this.property.getJsonInfoPath();
			List<String> listKey = this.property.getJsonInfoKeyList();
			for (String key : listKey) {
				String resourcePath = infoPath + key + ".json";
				if (flag) System.out.println(">>>>> resourcePath = " + resourcePath);

				switch (key) {
				case "MastInfo":
					content = ClassPathResourceReader.getInstance().getContent(resourcePath);
					this.mapInfo.put(key, this.objectMapper.readValue(content, MastInfo.class));
					break;
				case "StoreInfo":
					content = ClassPathResourceReader.getInstance().getContent(resourcePath);
					this.mapInfo.put(key, this.objectMapper.readValue(content, StoreInfo.class));
					break;
				case "Item01Info":
					content = ClassPathResourceReader.getInstance().getContent(resourcePath);
					this.mapInfo.put(key, this.objectMapper.readValue(content, Item01Info.class));
					break;
				case "Item23Info":
					content = ClassPathResourceReader.getInstance().getContent(resourcePath);
					this.mapInfo.put(key, this.objectMapper.readValue(content, Item23Info.class));
					break;
				case "ReqFieldInfo":
					content = ClassPathResourceReader.getInstance().getContent(resourcePath);
					this.mapInfo.put(key, this.objectMapper.readValue(content, ReqFieldInfo.class));
					break;
				case "ResFieldInfo":
					content = ClassPathResourceReader.getInstance().getContent(resourcePath);
					this.mapInfo.put(key, this.objectMapper.readValue(content, ResFieldInfo.class));
					break;
				default:
					throw new RuntimeException("KANG-ERROR: wrong key(" + key + ")");
				}
			}
		}
	}
	
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

	public synchronized ReqFieldInfo getReqFieldInfo(String stream) throws Exception {
		// stream = stream.replace('.', ' ');
		byte[] bytData = stream.getBytes("EUC-KR");
		int offset = 0;

		// Request Field Info
		ReqFieldInfo reqFieldInfo = new ReqFieldInfo();

		// MastInfo
		MastInfo mastInfo = (MastInfo) this.mapInfo.get("MastInfo");
		if (!flag) System.out.println("########## MastInfo: " + mastInfo);
		for (FieldInfo fieldInfo : mastInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();

			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));
		}
		reqFieldInfo.setMastInfo(mastInfo);

		// StoreInfo
		StoreInfo storeInfo = (StoreInfo) this.mapInfo.get("StoreInfo");
		if (!flag) System.out.println("########## StoreInfo: " + storeInfo);
		for (FieldInfo fieldInfo : storeInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();

			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));
		}
		reqFieldInfo.setStoreInfo(storeInfo);

		List<Item01Info> listItem01Info = new ArrayList<>();

		for (; offset < bytData.length;) {
			String id = new String(bytData, offset, 2, "EUC-KR");

			if ("01".equals(id)) {
				// Item01Info
				Item01Info item01Info = (Item01Info) this.mapInfo.get("Item01Info");
				if (!flag) System.out.println("########## Item01Info: " + item01Info);
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					offset += fieldInfo.getLength();

					// 필드 원본값 저장
					fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(getToValue(fieldInfo));
				}
				listItem01Info.add(item01Info);

			} else if ("23".equals(id)) {
				// Item23Info
				Item23Info item23Info = (Item23Info) this.mapInfo.get("Item23Info");
				if (!flag) System.out.println("########## Item23Info: " + item23Info);
				for (FieldInfo fieldInfo : item23Info.getFields()) {
					String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
					offset += fieldInfo.getLength();

					// 필드 원본값 저장
					fieldInfo.setFromValue(strField);
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(getToValue(fieldInfo));
				}
				reqFieldInfo.setItem23Info(item23Info);
			}
		}
		reqFieldInfo.setListItem01Info(listItem01Info);

		return reqFieldInfo;
	}

	public ReqDataInfo getReqDataInfo(ReqFieldInfo reqFieldInfo) {

		// json -> map (reqDataInfo)
		ReqDataInfo reqDataInfo = new ReqDataInfo();

		if (flag) {
			Map<String, String> map = new HashMap<>();
			for (FieldInfo fieldInfo : reqFieldInfo.getMastInfo().getFields()) {
				if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldName(), fieldInfo.getToValue());
				map.put(fieldInfo.getFieldName(), fieldInfo.getToValue());
			}
			reqDataInfo.setMastData(map);
		}

		if (flag) {
			Map<String, String> map = new HashMap<>();
			for (FieldInfo fieldInfo : reqFieldInfo.getStoreInfo().getFields()) {
				if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldName(), fieldInfo.getToValue());
				map.put(fieldInfo.getFieldName(), fieldInfo.getToValue());
			}
			reqDataInfo.setStoreData(map);
		}

		if (flag) {
			List<Map<String, String>> listMap = new ArrayList<>();
			for (Item01Info item01Info : reqFieldInfo.getListItem01Info()) {
				Map<String, String> map = new HashMap<>();
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldName(), fieldInfo.getToValue());
					map.put(fieldInfo.getFieldName(), fieldInfo.getToValue());
				}
				listMap.add(map);
			}
			reqDataInfo.setListItem01Data(listMap);
		}

		if (flag) {
			Map<String, String> map = new HashMap<>();
			for (FieldInfo fieldInfo : reqFieldInfo.getItem23Info().getFields()) {
				if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldName(), fieldInfo.getToValue());
				map.put(fieldInfo.getFieldName(), fieldInfo.getToValue());
			}
			reqDataInfo.setItem23Data(map);
		}

		return reqDataInfo;
	}

	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

	public ReqFieldInfo getReqFieldInfo(ReqDataInfo reqDataInfo) throws Exception {
		// reqFieldInfo
		ReqFieldInfo reqFieldInfo = new ReqFieldInfo();

		if (flag) {
			// MastInfo
			Map<String, String> map = reqDataInfo.getMastData();
			MastInfo mastInfo = new MastInfo();
			if (!flag) System.out.println("########## MastInfo: " + mastInfo);
			for (FieldInfo fieldInfo : mastInfo.getFields()) {
				// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
				fieldInfo.setToValue(map.get(fieldInfo.getFieldName()));
				// 필드 원본값 저장
				fieldInfo.setFromValue(getFromValue(fieldInfo));
			}
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mastInfo));  // 이쁜 출력

			reqFieldInfo.setMastInfo(mastInfo);
		}

		if (flag) {
			// StoreInfo
			Map<String, String> map = reqDataInfo.getStoreData();
			if (!flag) System.out.println("########## StoreInfo: " + storeInfo);
			for (FieldInfo fieldInfo : storeInfo.getFields()) {
				// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
				fieldInfo.setToValue(map.get(fieldInfo.getFieldName()));
				// 필드 원본값 저장
				fieldInfo.setFromValue(getFromValue(fieldInfo));
			}
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(storeInfo));  // 이쁜 출력

			reqFieldInfo.setStoreInfo(storeInfo);
		}

		if (flag) {
			// Item01Info
			List<Item01Info> listItem01Info = new ArrayList<>();
			for (Map<String, String> map : reqDataInfo.getListItem01Data()) {
				if (!flag) System.out.println("########## Item23Info: " + item01Info);
				for (FieldInfo fieldInfo : item01Info.getFields()) {
					// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
					fieldInfo.setToValue(map.get(fieldInfo.getFieldName()));
					// 필드 원본값 저장
					fieldInfo.setFromValue(getFromValue(fieldInfo));
				}
				if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item01Info));  // 이쁜 출력

				listItem01Info.add(item01Info);
			}
			reqFieldInfo.setListItem01Info(listItem01Info);
		}

		if (flag) {
			// Item23Info
			Map<String, String> map = reqDataInfo.getItem23Data();
			if (!flag) System.out.println("########## Item23Info: " + item23Info);
			for (FieldInfo fieldInfo : item23Info.getFields()) {
				// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
				fieldInfo.setToValue(map.get(fieldInfo.getFieldName()));
				// 필드 원본값 저장
				fieldInfo.setFromValue(getFromValue(fieldInfo));
			}
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(item23Info));  // 이쁜 출력

			reqFieldInfo.setItem23Info(item23Info);
		}

		//if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo));  // 이쁜 출력)

		return reqFieldInfo;
	}

	public String getStream(ReqFieldInfo reqFieldInfo) {
		// to stream data
		StringBuffer sb = new StringBuffer();

		for (FieldInfo fieldInfo : reqFieldInfo.getMastInfo().getFields()) {
			sb.append(fieldInfo.getFromValue());
		}

		for (FieldInfo fieldInfo : reqFieldInfo.getStoreInfo().getFields()) {
			sb.append(fieldInfo.getFromValue());
		}

		for (Item01Info item01Info : reqFieldInfo.getListItem01Info()) {
			for (FieldInfo fieldInfo : item01Info.getFields()) {
				sb.append(fieldInfo.getFromValue());
			}
		}

		for (FieldInfo fieldInfo : reqFieldInfo.getItem23Info().getFields()) {
			sb.append(fieldInfo.getFromValue());
		}

		return sb.toString();
	}

	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

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

	public ReqDataInfo getReqDataInfo(String json) throws Exception {
		ReqDataInfo reqDataInfo = this.objectMapper.readValue(json, ReqDataInfo.class);
		return reqDataInfo;
	}
	
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	
	private static ReqJson instance = null;
	
	public synchronized static ReqJson getInstance(Property property) throws Exception {
		if (instance == null) {
			instance = new ReqJson(property);
		}
		return instance;
	}
	
	public static ReqJson getInstance() throws Exception {
		return getInstance(null);
	}
}
