package org.tain.yaml01.yaml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.core.CollectionFactory;
import org.springframework.core.io.Resource;

public class YamlPropertiesProcessor extends YamlProcessor {

	public YamlPropertiesProcessor(Resource resource) throws IOException {
		if (!resource.exists()) {
			throw new FileNotFoundException();
		}
		this.setResources(resource);
	}
	
	public Properties createProperties() throws IOException {
		final Properties result = CollectionFactory.createStringAdaptingProperties();
		process((properties,map) -> result.putAll(properties));
		return result;
	}
}
