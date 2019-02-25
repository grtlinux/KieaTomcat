package org.tain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

@SpringBootApplication
public class SpringBoot2FepAdapterServerApplication implements CommandLineRunner {

	private static final boolean flag = true;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2FepAdapterServerApplication.class, args);
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (!flag) System.exit(0);
	}

	@Override
	public void run(String... args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (flag) {
			String reqJson = ""
					+ "{\"mastData\":{\"fld008\":\"60\",\"fld009\":\"1792\",\"fld006\":\"51501\",\"fld007\":\"2019/01/29\""
					+ ",\"fld004\":\"0\",\"fld005\":\"10\",\"fld002\":\"SH\",\"fld003\":\"0\",\"fld001\":\"1208\",\"fld010\":\"0000\"},"
					+ "\"storeData\":{\"fld030\":\"0\",\"fld019\":\"00\",\"fld017\":\"14:28:00\",\"fld039\":\"\",\"fld018\":\"00\""
					+ ",\"fld015\":\"2019/01/29\",\"fld037\":\"1\",\"fld016\":\"2019/01/29\",\"fld038\":\"0\",\"fld013\":\"60\",\"fld035\":\"0\""
					+ ",\"fld014\":\"1792\",\"fld036\":\"0\",\"fld011\":\"1168\",\"fld033\":\"1\",\"fld012\":\"51501\",\"fld034\":\"0\""
					+ ",\"fld031\":\"0\",\"fld032\":\"07\",\"fld040\":\"0\",\"fld041\":\"0\",\"fld028\":\"6000\",\"fld029\":\"0\",\"fld026\":\"6000\""
					+ ",\"fld027\":\"6000\",\"fld024\":\"\",\"fld025\":\"\",\"fld022\":\"\",\"fld023\":\"\",\"fld020\":\"900001\""
					+ ",\"fld042\":\"0\",\"fld021\":\"\",\"fld043\":\"0\"},"
					+ "\"listItem01Data\":[{\"fld051\":\"\",\"fld073\":\"0\",\"fld052\":\"2000\",\"fld074\":\"0\",\"fld071\":\"0\",\"fld072\":\"0\""
					+ ",\"fld070\":\"0\",\"fld059\":\"1\",\"fld057\":\"0\",\"fld079\":\"0\",\"fld058\":\"1\",\"fld055\":\"0\",\"fld077\":\"0\""
					+ ",\"fld056\":\"2000\",\"fld078\":\"0\",\"fld053\":\"1\",\"fld075\":\"0\",\"fld054\":\"2000\",\"fld076\":\"0\",\"fld040\":\"0\""
					+ ",\"fld062\":\"\",\"fld063\":\"2000\",\"fld060\":\"007324\",\"fld082\":\"8000000000\",\"fld061\":\"0\",\"fld080\":\"0\""
					+ ",\"fld081\":\"0\",\"fld048\":\"8801121107942\",\"fld049\":\"070730\",\"fld046\":\"3\",\"fld068\":\"0\",\"fld047\":\"0\""
					+ ",\"fld069\":\"0\",\"fld044\":\"01\",\"fld066\":\"\",\"fld045\":\"218\",\"fld067\":\"0\",\"fld064\":\"\",\"fld065\":\"0\"},"
					+ "{\"fld051\":\"\",\"fld073\":\"0\",\"fld052\":\"2000\",\"fld074\":\"0\",\"fld071\":\"0\",\"fld072\":\"0\",\"fld070\":\"0\""
					+ ",\"fld059\":\"1\",\"fld057\":\"0\",\"fld079\":\"0\",\"fld058\":\"1\",\"fld055\":\"0\",\"fld077\":\"0\",\"fld056\":\"2000\""
					+ ",\"fld078\":\"0\",\"fld053\":\"1\",\"fld075\":\"0\",\"fld054\":\"2000\",\"fld076\":\"0\",\"fld040\":\"0\",\"fld062\":\"\""
					+ ",\"fld063\":\"2000\",\"fld060\":\"007324\",\"fld082\":\"8000000000\",\"fld061\":\"0\",\"fld080\":\"0\",\"fld081\":\"0\""
					+ ",\"fld048\":\"8801121107942\",\"fld049\":\"070730\",\"fld046\":\"3\",\"fld068\":\"0\",\"fld047\":\"0\",\"fld069\":\"0\""
					+ ",\"fld044\":\"01\",\"fld066\":\"\",\"fld045\":\"218\",\"fld067\":\"0\",\"fld064\":\"\",\"fld065\":\"0\"},"
					+ "{\"fld051\":\"\",\"fld073\":\"0\",\"fld052\":\"2000\",\"fld074\":\"0\",\"fld071\":\"0\",\"fld072\":\"0\",\"fld070\":\"0\""
					+ ",\"fld059\":\"1\",\"fld057\":\"0\",\"fld079\":\"0\",\"fld058\":\"1\",\"fld055\":\"0\",\"fld077\":\"0\",\"fld056\":\"2000\""
					+ ",\"fld078\":\"0\",\"fld053\":\"1\",\"fld075\":\"0\",\"fld054\":\"2000\",\"fld076\":\"0\",\"fld040\":\"0\",\"fld062\":\"\""
					+ ",\"fld063\":\"2000\",\"fld060\":\"007324\",\"fld082\":\"8000000000\",\"fld061\":\"0\",\"fld080\":\"0\",\"fld081\":\"0\""
					+ ",\"fld048\":\"8801121107942\",\"fld049\":\"070730\",\"fld046\":\"3\",\"fld068\":\"0\",\"fld047\":\"0\",\"fld069\":\"0\""
					+ ",\"fld044\":\"01\",\"fld066\":\"\",\"fld045\":\"218\",\"fld067\":\"0\",\"fld064\":\"\",\"fld065\":\"0\"}],"
					+ "\"item23Data\":{\"fld095\":\"402857\",\"fld096\":\"2019/01/29\",\"fld093\":\"00584707\",\"fld094\":\"A\",\"fld091\":\"6000\""
					+ ",\"fld092\":\"545\",\"fld090\":\"0\",\"fld099\":\"롯데마스터카드\",\"fld097\":\"14:28:00\",\"fld098\":\"08\",\"fld084\":\"347\""
					+ ",\"fld085\":\"60\",\"fld083\":\"23\",\"fld107\":\"\",\"fld105\":\"5150100000201901296001792\""
					+ ",\"fld106\":\"0000000000000000000000000\",\"fld103\":\"0\",\"fld104\":\"00\",\"fld101\":\"롯데카드\""
					+ ",\"fld102\":\"134726386\",\"fld088\":\"KRKW\",\"fld089\":\"\",\"fld100\":\"08\",\"fld086\":\"0\",\"fld087\":\"402857\"}}";
			
			String json = FepHttp.getInstance().post("http://localhost:8087/adapter/info", reqJson);
			System.out.println(">>>>> json: " + json);
		}
	}
}
