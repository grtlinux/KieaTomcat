package org.tain.kang04.domain;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {
	private String title;
	private Integer serial;
	private List<Map<String,String>> list;
	private List<String> arr;
}
