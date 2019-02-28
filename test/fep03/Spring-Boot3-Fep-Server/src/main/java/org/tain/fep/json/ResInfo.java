package org.tain.fep.json;

import java.util.Arrays;

import org.tain.utils.BeanUtils;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ResInfo {

	private static final boolean flag = true;

	private ObjectNode reqDataNode;

	private ResFieldInfo resFieldInfo;
//	private ObjectNode _resDataNode;
//	private String _resDataJson;
	private String resStream;

	public ResInfo(ObjectNode reqDataNode) throws Exception {
		this.reqDataNode = reqDataNode;
		this.resFieldInfo = (ResFieldInfo) BeanUtils.getBean("json.ResFieldInfo");

		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (!flag) System.out.println(">>>>> reqDataNode: [" + this.reqDataNode + "]");
		if (!flag) System.out.println(">>>>> resFieldInfo: " + this.resFieldInfo);

		if (flag) {
			// MastInfo
			StringBuffer sb = new StringBuffer();
			JsonNode mastReqDataNode = this.reqDataNode.path("mastData");
			JsonNode resNode = this.resFieldInfo.path("mastInfo");
			for (JsonNode fldNode : resNode) {
				String fieldName = fldNode.path("fieldName").asText();
				String fieldType = fldNode.path("fieldType").asText();
				int len = fldNode.path("length").asInt();
				String fieldValue = null;
				switch (fieldType) {
				case "STRING":
				case "DATE":
				case "TIME":
					fieldValue = extend(mastReqDataNode.path(fieldName).asText(), fieldType, len);
					break;
				case "LONG":
					fieldValue = extend(mastReqDataNode.path(fieldName).asLong(), fieldType, len);
					break;
				case "INTEGER":
					fieldValue = extend(mastReqDataNode.path(fieldName).asInt(), fieldType, len);
					break;
				default:
					break;
				}

				// special field
				switch (fieldName) {
				case "fld001":
					fieldValue = "000040";
					break;
				default:
					break;
				}

				if (!flag) System.out.printf(">>>>> [%s:%s:%s]%n", fieldName, fieldType, fieldValue);
				sb.append(fieldValue);
			}

			this.resStream = sb.toString();
		}
	}

	public String getResStream() {
		return this.resStream;
	}

	//////////////////////////////////////////////////////

	@SuppressWarnings("unused")
	private String contract(String fieldValue, String fieldType) throws Exception {
		String ret = null;

		if (!fieldType.equals("STRING") && fieldValue.trim().length() > 0) {
			if (fieldType.equals("LONG")) {
				ret = String.format("%d", Long.parseLong(fieldValue));
			} else if (fieldType.equals("INTEGER")) {
				ret = String.format("%d", Integer.parseInt(fieldValue));
			} else if (fieldType.equals("DATE")) {
				ret = fieldValue.substring(0, 4) + "/" + fieldValue.substring(4, 6) + "/" + fieldValue.substring(6, 8);
			} else if (fieldType.equals("TIME")) {
				ret = fieldValue.substring(0, 2) + ":" + fieldValue.substring(2, 4) + ":" + fieldValue.substring(4, 6);
			} else {
				throw new Exception(String.format("ERROR: wrong FieldType '%s'..... in DocInfo.", fieldType));
			}
		} else {
			ret = fieldValue.trim();  // string은 공백 삭제ㅠ
		}

		return ret;
	}

	private String extend(Integer fieldValue, String fieldType, int len) throws Exception {
		return extend(String.valueOf(fieldValue), fieldType, len);
	}

	private String extend(Long fieldValue, String fieldType, int len) throws Exception {
		return extend(String.valueOf(fieldValue), fieldType, len);
	}

	private String extend(String fieldValue, String fieldType, int len) throws Exception {
		String ret = null;

		if ("STRING".equals(fieldType) || "".equals(fieldValue)) {
			// correct
			byte[] byt1 = fieldValue.getBytes("EUC-KR");
			byte[] byt2 = new byte[1024];
			Arrays.fill(byt2, (byte) ' ');
			System.arraycopy(byt1, 0, byt2, 0, byt1.length);
			ret = new String(byt2, 0, len, "EUC-KR");
		} else if ("LONG".equals(fieldType)) {
			ret = String.format("%0" + len + "d", Long.parseLong(fieldValue));
		} else if ("INTEGER".equals(fieldType)) {
			ret = String.format("%0" + len + "d", Integer.parseInt(fieldValue));
		} else if ("DATE".equals(fieldType)) {
			ret = fieldValue.replace("/", "");
		} else if ("TIME".equals(fieldType)) {
			ret = fieldValue.replace(":", "");
		} else {
			throw new Exception(String.format("ERROR: wrong FieldType '%s'..... in DocInfo.", fieldType));
		}

		return ret;
	}

	/////////////////////////////////////////////////
}
