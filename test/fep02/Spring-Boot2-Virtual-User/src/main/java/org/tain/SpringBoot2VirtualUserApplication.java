package org.tain;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

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
		for (int idx : arrIndex ) {
			json = FepHttp.getInstance().post("http://localhost:8085/reqStream/info", String.format("{\"index\": %d}", idx));
			if (flag) System.out.println(">>>>> json : " + json);
			Map<?,?> map = FepHttp.getInstance().getMap(json);
			if (flag) System.out.println(">>>>> map : " + map);
			
//			if ((Integer) map.get("status") != 200) {
//				if (flag) System.out.println(">>>>> ERROR: " + (String) map.get("message"));
//				break;
//			}

			json = FepHttp.getInstance().post("http://localhost:8086/virtualUser/info", json);
			if (flag) System.out.println(">>>>> json : " + json);
		}
	}
}
