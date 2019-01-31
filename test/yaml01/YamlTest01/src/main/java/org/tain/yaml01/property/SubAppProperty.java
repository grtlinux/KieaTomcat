package org.tain.yaml01.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.yaml01.yaml.YamlPropertySourceFactory;

import lombok.Data;

@Component
@PropertySource(
		value = {
				"classpath:/subApplication.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@Data
public class SubAppProperty {

	@Value("${sub-app.threadPool}")
	private Integer threadPool;
	
	@Value("${sub-app.email}")
	private String email;
}
