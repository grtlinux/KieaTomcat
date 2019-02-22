package org.tain.example.cli02;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.yml.YamlPropertySourceFactory;

import lombok.Data;

@Component(value = " example.cli02.ClientProperty")
@PropertySource(
		value = {
				"classpath:/application.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@ConfigurationProperties(prefix = "fep-client")
@Data
public class ClientProperty {

	private String program = "Fep Client Program";
	
	private Double version = 0.01;
	
	private String desc = "Description";
	
	private String author = "Kiea Seok Kang";
	
	private boolean active = true;
	
	private String host = "localhost";
	
	private Integer port = 2025;
}
