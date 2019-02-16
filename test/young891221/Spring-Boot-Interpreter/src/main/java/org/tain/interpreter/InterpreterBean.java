package org.tain.interpreter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "interpreter.InterpreterBean")
public class InterpreterBean {

	private static final String programFile = "static/program.txt";
	
	@Bean
	public void beanMain() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		try {
			Resource resource = new ClassPathResource(programFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			
			String text;
			while ((text = reader.readLine()) != null) {
				System.out.println(">>>>> " + text);
				
				Node node = new ProgramNode();
				node.parse(new Context(text));
				
				System.out.println("node = " + node);
			}
			
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
