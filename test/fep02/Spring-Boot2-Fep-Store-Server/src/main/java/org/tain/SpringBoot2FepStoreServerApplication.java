package org.tain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBoot2FepStoreServerApplication implements CommandLineRunner {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2FepStoreServerApplication.class, args);
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}

	@Override
	public void run(String... args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) {
			String json = FepHttp.getInstance().post("http://localhost:8093/store/info", "{\"fld001\": 990}");
			System.out.println(">>>>> json: " + json);
		}
	}
}
