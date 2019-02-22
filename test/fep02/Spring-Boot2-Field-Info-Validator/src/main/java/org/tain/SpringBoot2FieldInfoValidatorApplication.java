package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.controller.FieldInfoController;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBoot2FieldInfoValidatorApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2FieldInfoValidatorApplication.class, args);
		if (!flag) System.exit(0);
	}
	
	@Autowired
	private FieldInfoController fieldInfoController;
	
	@Bean
	public void test01() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) System.out.println(">>>>> " + this.fieldInfoController.list());
		if (flag) System.out.println(">>>>> " + this.fieldInfoController.field("MastInfo"));
	}
}
