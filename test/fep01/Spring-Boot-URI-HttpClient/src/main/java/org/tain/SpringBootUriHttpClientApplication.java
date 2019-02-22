package org.tain;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tain.httptest.HttpClientTest;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

@SpringBootApplication
public class SpringBootUriHttpClientApplication {

	private static final boolean flag = true;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUriHttpClientApplication.class, args);

		if (!flag) System.exit(0);
	}

	@Bean
	public CommandLineRunner runner() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (!flag) {
			// execute OK!!!
			new Thread() {
				@Override
				public void run() {
					if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

					if (flag) {
						int millisec = 2000;
						if (flag) System.out.printf(">>>>> Sleep.run(%d);%n", millisec);
						Sleep.run(millisec);
					}

					//HttpClient httpClient = new DefaultHttpClient();  // deprecated
					HttpClient httpClient = HttpClientBuilder.create().build();

					try {
						// specify the host, protocol, and port
						HttpHost host = new HttpHost("127.0.0.1", 8001, "http");
						// specify the get request
						//HttpGet req = new HttpGet("/field?name=MastInfo");
						HttpGet req = new HttpGet("/api/users");

						if (flag) System.out.println(">>>>> executing request to " + host + " " + req);
						HttpResponse res = httpClient.execute(host, req);

						if (flag) System.out.println("---------------------------------------------");
						System.out.println(res.getStatusLine());
						Header[] headers = res.getAllHeaders();
						for (int i=0; i < headers.length; i++) {
							System.out.println(headers[i]);
						}

						if (flag) System.out.println("---------------------------------------------");
						HttpEntity entity = res.getEntity();
						if (entity != null) {
							System.out.println(EntityUtils.toString(entity));
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
					}
				};
			}.start();
		}

		if (flag) {
			// execute OK!!!
			new Thread() {
				public void run() {
					new HttpClientTest().test01();
				}
			}.start();
		}

		if (flag) {

		}

		if (flag) {

		}

		return null;
	}
}
