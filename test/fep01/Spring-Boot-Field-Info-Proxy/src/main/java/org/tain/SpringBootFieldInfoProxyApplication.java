package org.tain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;


@SpringBootApplication
public class SpringBootFieldInfoProxyApplication {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFieldInfoProxyApplication.class, args);

		if (!flag) System.exit(0);
	}
	
	@Bean
	public void test01() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		String ret = null;
		ret = FepHttp.getInstance().postInfo("http://localhost:8081/fieldInfo/info", "{\"infoKey\": \"MastInfo\"}");
		if (flag) System.out.println(">>>>> postInfo ret : " + ret);

		ret = FepHttp.getInstance().getList("http://localhost:8081/fieldInfo/list");
		if (flag) System.out.println(">>>>> getList ret : " + ret);
	}
}
