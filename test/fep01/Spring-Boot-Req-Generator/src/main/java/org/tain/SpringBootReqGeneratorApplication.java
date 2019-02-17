package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
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

	////////////////////////////////////////////
	
	@Autowired
	private ReqGenerator reqGenerator;
	
	@Bean
	public void test01() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		byte[] byteReq;
		
		while ((byteReq = this.reqGenerator.getReqStreamLine()) != null) {
			System.out.println(">>>>> " + new String(byteReq, "EUC-KR"));
		}
	}
}
