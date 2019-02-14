package org.tain.example.info.enums;

public enum FieldType {

	STRING("문자열"),
	//VAR_STRING("가변길이문자열"),  // string.trim()을 적용한다.
	//FIX_STRING("고정길이문자열"),  // trim()을 적용하지 않는다.
	INTEGER("숫자"),
	LONG("큰숫자"),
	DATE("날짜"),
	TIME("시간");
	
	private String value;
	
	FieldType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public boolean isEqual(String fieldType) {
		return this.value.equals(fieldType);
	}
}
