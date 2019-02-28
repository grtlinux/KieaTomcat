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
		
		int cnt = 1;
		for (; cnt <= 1*60*60; cnt++) {
			String req = this.reqStream.get(cnt).replace('.', ' ');
			if (flag) System.out.printf(">>>>> [%5d] Client REQ: [%s]%n", cnt, req);
			
			String res = this.streamClient.runner(req);
			if (flag) System.out.printf(">>>>> [%5d] Client RES: [%s]%n", cnt, res);
			
			Sleep.run(1000);
		}
		
		if (flag) System.out.printf(">>>>> the counter of sending messages is [%d],%n", cnt);
	}
}
