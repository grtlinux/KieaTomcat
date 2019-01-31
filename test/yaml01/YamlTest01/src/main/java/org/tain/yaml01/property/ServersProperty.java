package org.tain.yaml01.property;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "servers")
@Data
public class ServersProperty {

	private String title;
	
	@NotNull
	private String email;
	
	//private List<Cluster> cluster = new ArrayList<>();
	private List<Cluster> cluster;
	
	@Data
	public static class Cluster {
		private String ip;
		private String path;
	}
}
