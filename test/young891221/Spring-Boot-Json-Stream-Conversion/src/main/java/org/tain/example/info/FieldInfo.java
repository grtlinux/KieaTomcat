package org.tain.example.info;

import java.io.Serializable;

import lombok.Data;

@Data
public class FieldInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldId;
	
	private String fieldName;
	
	private String name;
	
	//private Integer offset;
	
	private Integer length;
	
	private String fieldType;
	
	private String comment;
	
	private String fromValue;
	
	private String toValue;
}
