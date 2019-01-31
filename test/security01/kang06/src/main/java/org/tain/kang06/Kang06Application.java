package org.tain.kang06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.kang06.properties.Fruit;
import org.tain.kang06.properties.Property;
import org.tain.kang06.properties.Server;
import org.tain.kang06.properties.Thomson;

@SpringBootApplication(scanBasePackages = {
		"org.tain.kang06.properties",
		"org.tain.kang06.config",
		"org.tain.kang06.account",
		"org.tain.kang06.rest",
		"org.tain.kang06.web",
})
public class Kang06Application {

	public static void main(String[] args) {
		SpringApplication.run(Kang06Application.class, args);
	}

	//////////////////////////////////////////////////////////////////
	
	@Autowired
	private Server server;
	
	@Autowired
	private Property property;
	
	@Autowired
	private Fruit fruit;
	
	@Autowired
	private Thomson thomson;
	
	@Bean
	public void checkProperties() {
		System.out.println(">>>>> server = " + server);
		System.out.println(">>>>> property = " + property);
		System.out.println(">>>>> fruit = " + fruit);
		System.out.println(">>>>> thomson = " + thomson);
	}
}

