package org.tain.fep.test;

import org.springframework.context.annotation.Bean;
import org.tain.fep.reqgenerator.ReqGenerator;
import org.tain.utils.ClassUtil;

public class ReqGeneratorTest01 {

	private static final boolean flag = true;
	
	////////////////////////////////////////////
	
	@Bean
	public void test01() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) {
			ReqGenerator reqGenerator = ReqGenerator.getInstance();
			for (String line : reqGenerator.getList()) {
				System.out.println(">>>>> " + line);
			}
			
			System.out.println(">>>>> size = " + reqGenerator.size());
			
			System.out.println(">>>>> " + reqGenerator.get(10));
		}
	}
}
