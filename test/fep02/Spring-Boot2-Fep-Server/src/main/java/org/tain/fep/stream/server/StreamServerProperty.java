package org.tain.fep.stream.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.yml.YamlPropertySourceFactory;

import lombok.Data;

@Component(value = "fep.stream.server.StreamServerProperty")
@PropertySource(
		value = {
				"classpath:/application.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@ConfigurationProperties(prefix = "stream-server")
@Data
public class StreamServerProperty {

	private String program = "Fep Server Program";
	
	private Double version = 0.01;
	
	private String desc = "Description";
	
	private String author = "Kiea Seok Kang";
	
	private boolean active = true;
	
	private Integer listenPort = 2025;
}
