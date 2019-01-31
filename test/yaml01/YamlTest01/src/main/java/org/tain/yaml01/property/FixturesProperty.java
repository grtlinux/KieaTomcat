package org.tain.yaml01.property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "fixtures")
public class FixturesProperty {

	private List<Map<String, String>> articles = new ArrayList<>();
	
	public List<Map<String, String>> getArticles() {
		return articles;
	}
}
