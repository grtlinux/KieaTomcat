package org.tain.kang04;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.kang04.domain.FruitProperty;

@SpringBootApplication
public class Kang04Application {

	public static void main(String[] args) {
		SpringApplication.run(Kang04Application.class, args);
	}
	
	///////////////////////////////////////////////////////////////
	
	@Value("${property.test.name}")
	private String propertyTestName;

	@Value("${org.tain.server.port}")
	private String orgTainServerPort;
	
	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private FruitProperty fruitProperty;

	@Bean
	public void hello() {
		System.out.println(">>>>> Bean");
		
		System.out.println(">>>>> property.test.name = " + this.propertyTestName);
		System.out.println(">>>>> org.tain.server.port = " + this.orgTainServerPort);
		System.out.println(">>>>> server.port = " + this.serverPort);

		String title = this.fruitProperty.getTitle();
		Integer serial = this.fruitProperty.getSerial();
		List<Map<String, String>> list = this.fruitProperty.getList();
		List<String> arr = this.fruitProperty.getArr();
		
		System.out.println(">>>>> title = " + title);
		System.out.println(">>>>> serial = " + serial);
		System.out.println(">>>>> list = " + list);
		System.out.println(">>>>> arr = " + arr);
		System.out.println(">>>>> this.fruitProperty = " + this.fruitProperty);
	}
}

