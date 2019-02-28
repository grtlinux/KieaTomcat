package org.tain.fep.json;

import java.util.Arrays;

import org.tain.utils.BeanUtils;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReqInfo {
	
	private static final boolean flag = true;
	
	private String reqStream;
	private ReqFieldInfo reqFieldInfo;
	private ObjectNode reqDataNode;
	private String reqDataJson;
	
	public ReqInfo(String reqStream) throws Exception {
		this.reqStream = reqStream;
		this.reqFieldInfo = (ReqFieldInfo) BeanUtils.getBean("json.ReqFieldInfo");
		
		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (!flag) System.out.println(">>>>> reqStream: [" + this.reqStream + "]");
		if (!flag) System.out.println(">>>>> reqFieldInfo: " + this.reqFieldInfo);
		
		//test01();
		
		byte[] reqBytes = reqStream.getBytes("EUC-KR");
		int off = 0;
		
		this.reqDataNode = this.reqFieldInfo.getObjectMapper().createObjectNode();
		ObjectNode node;

		if (flag) {
			// MastInfo
			node = this.reqFieldInfo.getObjectMapper().createObjectNode();
			JsonNode reqNode = this.reqFieldInfo.path("mastInfo");
			for (JsonNode fldNode : reqNode) {
				int size = fldNode.path("length").asInt();
				
				String fieldName = fldNode.path("fieldName").asText();
				String fieldValue = new String(reqBytes, off, size, "EUC-KR");
				String fieldType = fldNode.path("fieldType").asText();
				fieldValue = contract(fieldValue, fieldType);
				
				if (!flag) System.out.printf(">>>>> [%s:%s]%n", fieldName, fieldValue);
				switch (fieldType) {
				case "STRING":
				case "DATE":
				case "TIME":
					node.put(fieldName, fieldValue);
					break;
				case "LONG":
					node.put(fieldName, Long.parseLong(fieldValue));
					break;
				case "INTEGER":
					node.put(fieldName, Integer.parseInt(fieldValue));
					break;
				default:
					break;
				}
				
				off += size;
			}
			((ObjectNode)this.reqDataNode).set("mastData", node);
		}

		if (flag) {
			// StoreInfo
			node = this.reqFieldInfo.getObjectMapper().createObjectNode();
			JsonNode reqNode = this.reqFieldInfo.path("storeInfo");
			for (JsonNode fldNode : reqNode) {
				int size = fldNode.path("length").asInt();
				
				String fieldName = fldNode.path("fieldName").asText();
				String fieldValue = new String(reqBytes, off, size, "EUC-KR");
				String fieldType = fldNode.path("fieldType").asText();
				fieldValue = contract(fieldValue, fieldType);
				
				if (!flag) System.out.printf(">>>>> [%s:%s]%n", fieldName, fieldValue);
				switch (fieldType) {
				case "STRING":
				case "DATE":
				case "TIME":
					node.put(fieldName, fieldValue);
					break;
				case "LONG":
					node.put(fieldName, Long.parseLong(fieldValue));
					break;
				case "INTEGER":
					node.put(fieldName, Integer.parseInt(fieldValue));
					break;
				default:
					break;
				}
				
				off += size;
			}
			((ObjectNode)this.reqDataNode).set("storeData", node);
		}
		
		if (flag) {
			// Item01Info & Item23Info
			ArrayNode arrNode = this.reqFieldInfo.getObjectMapper().createArrayNode();
			((ObjectNode) this.reqDataNode).set("item01Data", arrNode);
			
			for (; off < reqBytes.length;) {
				String id = new String(reqBytes, off, 2, "EUC-KR");
				
				if ("01".equals(id)) {
					// Item01Info
					node = this.reqFieldInfo.getObjectMapper().createObjectNode();
					JsonNode reqNode = this.reqFieldInfo.path("item01Info");
					for (JsonNode fldNode : reqNode) {
						int size = fldNode.path("length").asInt();
						
						String fieldName = fldNode.path("fieldName").asText();
						String fieldValue = new String(reqBytes, off, size, "EUC-KR");
						String fieldType = fldNode.path("fieldType").asText();
						fieldValue = contract(fieldValue, fieldType);
						
						if (!flag) System.out.printf(">>>>> [%s:%s]%n", fieldName, fieldValue);
						switch (fieldType) {
						case "STRING":
						case "DATE":
						case "TIME":
							node.put(fieldName, fieldValue);
							break;
						case "LONG":
							node.put(fieldName, Long.parseLong(fieldValue));
							break;
						case "INTEGER":
							node.put(fieldName, Integer.parseInt(fieldValue));
							break;
						default:
							break;
						}
						
						off += size;
					}
					arrNode.add(node);
				} else if ("23".equals(id)) {
					// Item23Info
					node = this.reqFieldInfo.getObjectMapper().createObjectNode();
					JsonNode reqNode = this.reqFieldInfo.path("item23Info");
					for (JsonNode fldNode : reqNode) {
						int size = fldNode.path("length").asInt();
						
						String fieldName = fldNode.path("fieldName").asText();
						String fieldValue = new String(reqBytes, off, size, "EUC-KR");
						String fieldType = fldNode.path("fieldType").asText();
						fieldValue = contract(fieldValue, fieldType);
						
						if (!flag) System.out.printf(">>>>> [%s:%s]%n", fieldName, fieldValue);
						switch (fieldType) {
						case "STRING":
						case "DATE":
						case "TIME":
							node.put(fieldName, fieldValue);
							break;
						case "LONG":
							node.put(fieldName, Long.parseLong(fieldValue));
							break;
						case "INTEGER":
							node.put(fieldName, Integer.parseInt(fieldValue));
							break;
						default:
							break;
						}
						
						off += size;
					}
					((ObjectNode)this.reqDataNode).set("item23Data", node);
				}
			}
			
		}
		
		this.reqDataJson = this.reqFieldInfo.getObjectMapper().writeValueAsString(this.reqDataNode);
		if (!flag) System.out.println(">>>>> reqDataJson = " + this.reqDataJson);
		
		if (!flag) System.out.println(">>>>> " + this.reqFieldInfo.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this.reqDataNode));
	}
	
	//////////////////////////////////////////////////////
	
	public String getReqStream() {
		return this.reqStream;
	}
	
	public ReqFieldInfo getReqFieldInfo() {
		return this.reqFieldInfo;
	}
	
	public ObjectNode getReqDataNode() {
		return this.reqDataNode;
	}
	
	public String getReqDataJson() {
		return this.reqDataJson;
	}
	
	//////////////////////////////////////////////////////

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
	
	@SuppressWarnings("unused")
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
	
	//////////////////////////////////////////////
	
	@SuppressWarnings("unused")
	private void test01() {
		
		JsonNode mastNode = this.reqFieldInfo.path("mastInfo");
		if (mastNode.isArray()) {
			for (JsonNode fldNode : mastNode) {
//				if (!flag) {
//					Iterator<Map.Entry<String,JsonNode>> iter = fldNode.fields();
//					while (iter.hasNext()) {
//						Map.Entry<String,JsonNode> entry = iter.next();
//						if (flag) System.out.printf(">>>>> [%s : %s]%n", entry.getKey(), entry.getValue());
//					}
//					System.out.println();
//				}
				if (flag) System.out.println(">>>>> fldNode : " + fldNode);
				if (flag) System.out.printf(">>>>> [fieldId   : %s]%n", fldNode.path("fieldId").asText());
				if (flag) System.out.printf(">>>>> [fieldName : %s]%n", fldNode.path("fieldName").asText());
				if (flag) System.out.printf(">>>>> [length    : %d]%n", fldNode.path("length").asInt());
				if (flag) System.out.printf(">>>>> [fieldType : %s]%n", fldNode.path("fieldType").asText());
				if (flag) System.out.println();
			}
		}
	}
}
