package org.tain.yml;

import java.io.IOException;

import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.support.EncodedResource;

public class YamlResourcePropertySource extends PropertiesPropertySource {

	protected YamlResourcePropertySource(String name, EncodedResource resource) throws IOException {
		super(name, new YamlPropertiesProcessor(resource.getResource()).createProperties());
	}

}
