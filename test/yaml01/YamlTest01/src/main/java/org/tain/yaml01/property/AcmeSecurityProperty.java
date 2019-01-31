package org.tain.yaml01.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "acme")
@Data
public class AcmeSecurityProperty {
	
	//private List<Map<String, String>> security;
	
	private List<SecurityUser> security;
	
	@Data
	public static class SecurityUser {
		private String username;
		private String password;
		private String[] roles;
	}
}
