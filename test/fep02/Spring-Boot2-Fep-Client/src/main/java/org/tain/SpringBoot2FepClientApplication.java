package org.tain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.utils.ClassUtil;

@SpringBootApplication
//public class SpringBoot2FepClientApplication {
public class SpringBoot2FepClientApplication implements CommandLineRunner {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2FepClientApplication.class, args);
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (flag) System.exit(0);
	}

	@Override
	public void run(String... args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) {
			try {
				String message = "000990SH0000000851501201901296001790000000095051501600179020190129201901291335000000900001.................................0000002250000002250000002250000000000000000000000000000070100010................000001218001000000880027980700120......0000001300001000001300000000000000001300000110073240..........000001300......000000000......000000000000000000000000000000000000000000000000000000000000000000000000000000000800000000001218002088011151344350701420......0000000950001000000950000000000000000950000110073240..........000000950......000000000......00000000000000000000000000000000000000000000000000000000000000000000000000000000080000000002334760000000533872..........KRKW................0000000225000000020552063467....A533872...............................2019012913350009..롯데마스터카드......09..롯데카드............9966089516.....000000000005150100000201901296001790.....0000000000000000000000000.....................................................................................";
				message = message.replace('.', ' ');
				org.tain.fep.example.client.StreamClient.getInstance().runner(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
