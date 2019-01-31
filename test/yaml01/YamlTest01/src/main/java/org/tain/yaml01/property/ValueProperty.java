package org.tain.yaml01.property;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ValueProperty {

	@Value("${property.test.name}")
	private String propertyTestName;
	
	@Value("${propertyTest}")
	private String propertyTest;
	
	@Value("${noKey:defaut value}")
	private String defaultValue;
	
	@Value("${propertyTestList}")
	private String[] propertyTestArray;
	
	@Value("#{'${propertyTestList}'.split('\\s*,\\s*')}")
	private List<String> propertyTestList;
	
	//@Value("${info.build}")
	//private Map<String, String> infoBuild = new HashMap<>();
}
