package org.tain.fep.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.tain.fep.http.FepHttp;
import org.tain.fep.info.FieldInfo;
import org.tain.fep.info.MastInfo;
import org.tain.fep.info.ResDataInfo;
import org.tain.fep.info.ResFieldInfo;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResJson {

	private static final boolean flag = true;
	
	private static final String URL_FIELD_INFO = "http://localhost:8082/fieldInfo/info";
	private ObjectMapper objectMapper = null;
	private MastInfo mastInfo = null;

	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

	private ResJson() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) {
			this.objectMapper = new ObjectMapper();

			String jsonInfo = null;

			jsonInfo = FepHttp.getInstance().post(URL_FIELD_INFO, "{\"infoKey\": \"MastInfo\"}");
			if (!flag) System.out.println(">>>>> MastInfo: " + jsonInfo);
			this.mastInfo = this.objectMapper.readValue(jsonInfo, MastInfo.class);
		}
	}
	
	public ResFieldInfo getResFieldInfo(String stream) throws Exception {
		// stream = stream.replace('.', ' ');
		byte[] bytData = stream.getBytes("EUC-KR");
		int offset = 0;

		// Request Field Info
		ResFieldInfo resFieldInfo = new ResFieldInfo();

		// MastInfo
		if (!flag) System.out.println("########## MastInfo: " + mastInfo);
		for (FieldInfo fieldInfo : this.mastInfo.getFields()) {
			String strField = new String(bytData, offset, fieldInfo.getLength(), "EUC-KR");
			offset += fieldInfo.getLength();

			// 필드 원본값 저장
			fieldInfo.setFromValue(strField);
			// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
			fieldInfo.setToValue(getToValue(fieldInfo));
		}
		resFieldInfo.setMastInfo(mastInfo);

		return resFieldInfo;
	}

	public ResDataInfo getResDataInfo(ResFieldInfo resFieldInfo) {

		// json -> map (resDataInfo)
		ResDataInfo resDataInfo = new ResDataInfo();

		if (flag) {
			Map<String, String> map = new HashMap<>();
			for (FieldInfo fieldInfo : resFieldInfo.getMastInfo().getFields()) {
				if (!flag) System.out.printf(">>>>> '%s' : '%s'%n", fieldInfo.getFieldName(), fieldInfo.getToValue());
				map.put(fieldInfo.getFieldName(), fieldInfo.getToValue());
			}
			resDataInfo.setMastData(map);
		}
		
		return resDataInfo;
	}

	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

	public ResFieldInfo getResFieldInfo(ResDataInfo resDataInfo) throws Exception {
		// resFieldInfo
		ResFieldInfo resFieldInfo = new ResFieldInfo();

		if (flag) {
			// MastInfo
			Map<String, String> map = resDataInfo.getMastData();
			if (!flag) System.out.println("########## MastInfo: " + mastInfo);
			for (FieldInfo fieldInfo : this.mastInfo.getFields()) {
				// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
				fieldInfo.setToValue(map.get(fieldInfo.getFieldName()));
				// 필드 원본값 저장
				fieldInfo.setFromValue(getFromValue(fieldInfo));
			}
			if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mastInfo));  // 이쁜 출력

			resFieldInfo.setMastInfo(mastInfo);
		}

		//if (!flag) System.out.println(">>>>> " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqFieldInfo));  // 이쁜 출력)

		return resFieldInfo;
	}

	public String getStream(ResFieldInfo reqFieldInfo) {
		// to stream data
		StringBuffer sb = new StringBuffer();

		for (FieldInfo fieldInfo : reqFieldInfo.getMastInfo().getFields()) {
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

	@SuppressWarnings("unused")
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

	public ResDataInfo getResDataInfo(String json) throws Exception {
		ResDataInfo resDataInfo = this.objectMapper.readValue(json, ResDataInfo.class);
		return resDataInfo;
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
	
	private static ResJson instance = null;
	
	public synchronized static ResJson getInstance() throws Exception {
		if (instance == null) {
			instance = new ResJson();
		}
		return instance;
	}
}
