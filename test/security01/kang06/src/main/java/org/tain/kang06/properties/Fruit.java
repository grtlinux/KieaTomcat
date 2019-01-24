package org.tain.kang06.properties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("fruit")
public class Fruit {

	private String title;
	private Integer count;
	private List<Map<String, Object>> list;
	private List<String> country;
}
