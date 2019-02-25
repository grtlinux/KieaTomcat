package org.tain.domain.enums;

public enum SocialType {

	FACEBOOK("facebook"),
	GOOGLE("google"),
	KAKAO("kakao");
	
	private String value;
	
	SocialType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	//////////////////////////////////
	
	private static final String ROLE_PREFIX = "ROLE_";

	public String getRoleType() {
		return ROLE_PREFIX + this.value.toUpperCase();
	}
	
	public boolean isEquals(String authority) {
		return this.getRoleType().equals(authority);
	}
}
