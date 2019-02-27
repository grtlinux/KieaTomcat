package org.tain.fep.json;

import org.springframework.stereotype.Component;
import org.tain.fep.property.Property;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "json.ReqFieldInfo")
public class ReqFieldInfo {

	private static final boolean flag = true;
	
	private Property property;
	private String reqFieldInfoPath;
	private String reqContent;
	private ObjectMapper objectMapper;
	private JsonNode reqNode;
	
	public ReqFieldInfo(Property property) throws Exception {
		this.property = property;
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (flag) System.out.println(">>>>> ReqFieldInfo.Property -> " + this.property);
		
		this.reqFieldInfoPath = this.property.getReqFieldInfo();
		if (flag) System.out.println(">>>>> reqFieldInfoPath: " + this.reqFieldInfoPath);
		this.reqContent = ClassPathResourceReader.getInstance().getContent(this.reqFieldInfoPath);
		if (flag) System.out.println(">>>>> reqContent: " + this.reqContent);
		this.objectMapper = new ObjectMapper();
		this.reqNode = this.objectMapper.readTree(this.reqContent);
	}
	
	public ObjectMapper getObjectMapper() {
		return this.objectMapper;
	}
	
	public JsonNode root() {
		return this.reqNode;
	}
	
	public JsonNode path(String fieldName) {
		return this.reqNode.path(fieldName);
	}
	
	public String toString() {
		return this.reqContent;
	}
}
