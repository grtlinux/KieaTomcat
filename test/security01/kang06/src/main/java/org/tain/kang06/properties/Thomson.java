package org.tain.kang06.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
//@ConfigurationProperties(locations="classpath:abc.yml", prefix="org.tain.thomson")
@ConfigurationProperties("org.tain.thomson")
public class Thomson {

	private String name;
	
	private Udp udp;
	
	@Value("${org.tain.thomson.udp.ip}")
	private String udpIp;
	
	@Value("${org.tain.thomson.udp.port}")
	private Integer udpPort;
	
	@Value("${org.tain.thomson.listen.port}")
	private Integer listenPort;
}
