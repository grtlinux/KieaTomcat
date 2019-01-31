package org.tain.yaml01.property;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "fixtures")
@Data
public class FixturesProperty2 {

	private List<Info> articles = new ArrayList<>();
	
	@Data
	public static class Info {
		private Integer id;
		private String title;
		private String content;
	}
}
