package org.tain.test;

import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "test.HttpClientTest01")
public class HttpClientTest01 {

	private static final boolean flag = true;
	
	@Bean(value = "test.HttpClientTest01.test01")
	public void test01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		try {
			// REQ
			HttpHost httpHost = new HttpHost("localhost", 8081, "http");
			HttpGet httpGet = new HttpGet("/field/MastInfo");
			if (flag) System.out.printf("[HttpHost:%s] [HttpGet:%s]%n", httpHost, httpGet);
			
			// RES
			HttpResponse httpResponse = httpClient.execute(httpHost, httpGet);
			if (flag) System.out.println(">>>>> httpResponse.getStatusLine()\n" + httpResponse.getStatusLine());
			if (flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));
			HttpEntity httpEntity = httpResponse.getEntity();
			if (flag) System.out.println(">>>>> httpResponse.getEntity()\n" + EntityUtils.toString(httpEntity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
