package org.tain.kang06.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Property {

	@Value("${property.test.name}")
	private String propertyTestName;
	
	@Value("${propertyTest}")
	private String propetyTest;
	
	@Value("${noKey:default value}")
	private String defaultValue;
	
	@Value("${propertyTestList}")
	private String[] arrProperty;
	
	@Value("#{'${propertyTestList}'.split(',')}")
	private List<String> listProperty;
}
