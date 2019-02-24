package org.tain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBoot2ResJsonGeneratorApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2ResJsonGeneratorApplication.class, args);
		if (!flag) System.exit(0);
	}
	
	@Bean
	public void test01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		//if (flag) System.out.println(">>>>> " + FieldInfo.getInstance().getList());
		//if (flag) System.out.println(">>>>> " + FieldInfo.getInstance().get("MastInfo"));
	}
}
