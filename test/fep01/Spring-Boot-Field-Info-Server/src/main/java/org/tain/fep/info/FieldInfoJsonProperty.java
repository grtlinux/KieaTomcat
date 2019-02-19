package org.tain.fep.info;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.yml.YamlPropertySourceFactory;

import lombok.Data;

@Component(value = "fep.info.FieldInfoJsonProperty")
@PropertySource(
		value = {
				"classpath:/application.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@ConfigurationProperties(prefix = "req-generator")
@Data
public class FieldInfoJsonProperty {

	private String program = "Fep Server Program";
	
	private Double version = 0.01;
	
	private String desc = "Description";
	
	private String author = "Kiea Seok Kang";
	
	private boolean active = true;
	
	private Integer listenPort = 2025;
}
