package org.tain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.fep.proxy.FieldInfoProxy;
import org.tain.utils.ClassUtil;


@SpringBootApplication
public class SpringBootFieldInfoProxyApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFieldInfoProxyApplication.class, args);

		if (flag) System.exit(0);
	}

	@Bean(value = "Application.test01")
	public void test01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		System.out.println("1 >>>>> " + FieldInfoProxy.get("MastInfo"));
		System.out.println("2 >>>>> " + FieldInfoProxy.get("MastInfo"));
		System.out.println("3 >>>>> " + FieldInfoProxy.get("MastInfo"));
	}
}
