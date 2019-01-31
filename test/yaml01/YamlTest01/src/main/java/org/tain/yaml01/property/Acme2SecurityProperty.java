package org.tain.yaml01.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.yaml01.yaml.YamlPropertySourceFactory;

import lombok.Data;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "acme2")
@PropertySource(
		value = {
				"classpath:/subApplication.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@Data
public class Acme2SecurityProperty {
	
	//private List<Map<String, String>> security;
	
	private List<SecurityUser> security;
	
	@Data
	public static class SecurityUser {
		private String username;
		private String password;
		private String[] roles;
	}
}
