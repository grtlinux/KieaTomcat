package org.tain.example.resource01;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "example.resource01.ResourcesExample")
public class ResourcesExample {

	@Bean
	public void test01() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
}
