package org.tain.yaml01.property;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "myconfig.dbconfig")
@Data
public class DbConfigProperty {
	
	@Value("${propertyTest}")
	private String propertyTest;
	
	private String needUpdateScheme = "false";
	private Map<String, DatabaseProperty> databases = new HashMap<>();
	private String dataUpdateType = "prod";
	
	@Data
	public static class DatabaseProperty {
		@NotNull
		private String url;
		private String username;
		private String password;
	}
}
