package org.tain.kang06.properties;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Udp {
	private String ip;
	private Integer port;
}
