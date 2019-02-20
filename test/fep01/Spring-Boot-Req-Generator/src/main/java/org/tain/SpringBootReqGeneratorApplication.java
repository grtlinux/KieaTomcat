package org.tain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.fep.reqgenerator.ReqGenerator;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBootReqGeneratorApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootReqGeneratorApplication.class, args);
		
		if (flag) System.exit(0);
	}
	
	@Bean
	public void test01() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) System.out.println(">>>>> count: " + ReqGenerator.getInstance().size());
	}
}
