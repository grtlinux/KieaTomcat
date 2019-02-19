package org.tain.httptest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class HttpClientTest {

	private static final boolean flag = true;
	
	public void test01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		//HttpClient httpClient = new DefaultHttpClient();  // deprecated
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		try {
			// specify the host, protocol, and port
			HttpHost host = new HttpHost("127.0.0.1", 8081, "http");
			// specify the get request
			//HttpGet req = new HttpGet("/field?name=MastInfo");
			HttpGet req = new HttpGet("/field");
			
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
			// TODO: handle exception
		}
	}
}