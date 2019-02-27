package org.tain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.fep.property.Property;
import org.tain.fep.req.ReqStream;
import org.tain.fep.stream.client.StreamClient;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

@SpringBootApplication
public class SpringBoot3FepClientApplication implements CommandLineRunner {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3FepClientApplication.class, args);
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) System.exit(0);
	}

	//////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Property property;
	
	@Autowired
	private ReqStream reqStream;
	
	@Autowired
	private StreamClient streamClient;
	
	@Override
	public void run(String... args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (flag) System.out.println(">>>>> Property -> " + this.property);
		
		for (int i=0; i < 1; i++) {
			String req = this.reqStream.get(i).replace('.', ' ');
			if (flag) System.out.println(">>>>> Client REQ: [" + req + "]");
			
			String res = this.streamClient.runner(req);
			if (flag) System.out.println(">>>>> Client RES: [" + res + "]");
			
			Sleep.run(1000);
		}
	}
}
