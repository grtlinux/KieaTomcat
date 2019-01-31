package org.tain.yaml01.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.tain.yaml01.yaml.YamlPropertySourceFactory;

import lombok.Data;

@Component
@PropertySource(
		value = {
				"classpath:/udpServers.yml",
				"file:/data/imsi.yml"
		},
		ignoreResourceNotFound = true,
		factory = YamlPropertySourceFactory.class
)
@ConfigurationProperties(prefix = "udp-servers")
@Data
public class UdpServersProperty {

	private List<String> list;
}
