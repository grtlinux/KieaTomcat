package org.tain.httptest;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
