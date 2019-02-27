package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.fep.property.Property;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBoot3FepServerApplication implements CommandLineRunner {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3FepServerApplication.class, args);
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) System.exit(0);
	}

	//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Property property;
	
	@Override
	public void run(String... args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (flag) System.out.println(">>>>> " + this.property);
	}
}
