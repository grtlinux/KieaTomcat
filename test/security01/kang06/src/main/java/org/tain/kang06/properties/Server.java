package org.tain.kang06.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("server")
public class Server {

	private String name;
	private Integer port;
}
