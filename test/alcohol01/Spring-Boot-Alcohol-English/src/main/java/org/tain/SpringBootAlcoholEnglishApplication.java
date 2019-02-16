package org.tain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBootAlcoholEnglishApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAlcoholEnglishApplication.class, args);
		
		if (flag) System.exit(0);
	}

	@Bean
	public void test01() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Resource resource = new ClassPathResource("static/content.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(">>>>> " + line);
		}
		reader.close();
	}
}
