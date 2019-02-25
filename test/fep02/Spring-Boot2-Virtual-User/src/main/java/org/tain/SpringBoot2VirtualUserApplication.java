package org.tain;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

@SpringBootApplication
public class SpringBoot2VirtualUserApplication implements CommandLineRunner {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2VirtualUserApplication.class, args);
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (flag) System.exit(0);
	}

	@Override
	public void run(String... args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		String json;
		
		//int[] arrIndex = new int[] { 0, 1, 2, 3 };
		int[] arrIndex = new int[] { 0, 1, 2 };
		//int[] arrIndex = new int[] { 0 };

		for (int i=0; i < 10; i++) {
			for (int idx : arrIndex ) {
				if (flag) {
					json = FepHttp.getInstance().post("http://localhost:8085/reqStream/info", String.format("{\"index\": %d}", idx));
					if (flag) System.out.println(">>>>> REQ json : " + json);
					Map<?,?> map = FepHttp.getInstance().getMap(json);
					if (flag) System.out.println(">>>>> REQ map : " + map);
				}
				
				if (flag) {
					json = FepHttp.getInstance().post("http://localhost:8087/adapter/info", json);
					if (flag) System.out.println(">>>>> RES json : " + json);
				}
				
				Sleep.run(2000);
			}
		}
	}
}
