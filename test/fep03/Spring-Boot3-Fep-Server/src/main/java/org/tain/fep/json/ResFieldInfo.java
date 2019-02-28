package org.tain.fep.json;

import org.springframework.stereotype.Component;
import org.tain.fep.property.Property;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "json.ResFieldInfo")
public class ResFieldInfo {

	private static final boolean flag = true;
	
	private Property property;
	private String resFieldInfoPath;
	private String resContent;
	private ObjectMapper objectMapper;
	private JsonNode resNode;
	
	public ResFieldInfo(Property property) throws Exception {
		this.property = property;
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (!flag) System.out.println(">>>>> ResFieldInfo.Property -> " + this.property);
		
		this.resFieldInfoPath = this.property.getResFieldInfo();
		if (!flag) System.out.println(">>>>> resFieldInfoPath: " + this.resFieldInfoPath);
		this.resContent = ClassPathResourceReader.getInstance().getContent(this.resFieldInfoPath);
		if (!flag) System.out.println(">>>>> resContent: " + this.resContent);
		this.objectMapper = new ObjectMapper();
		this.resNode = this.objectMapper.readTree(this.resContent);
	}
	
	public ObjectMapper getObjectMapper() {
		return this.objectMapper;
	}
	
	public JsonNode root() {
		return this.resNode;
	}
	
	public JsonNode path(String fieldName) {
		return this.resNode.path(fieldName);
	}
	
	public String toString() {
		return this.resContent;
	}
}
