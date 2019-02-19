package org.tain.utils;

import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientResponse {

	private static final boolean flag = true;

	private HttpClient httpClient = null;
	
	private HttpClientResponse() {
		if (flag) {
			this.httpClient = HttpClientBuilder.create().build();
		}
		
		if (!flag) {
			// get stream
			// get FieldInfo from Field-Info-Server
			/*
			String entity = null;
			try {
				HttpHost httpHost = new HttpHost("localhost", 8083, "http");
				HttpGet httpGet = new HttpGet("/generator/req/" + 0);
				if (flag) System.out.printf(">>>>> [HttpHost:%s] [HttpGet:%s]%n", httpHost, httpGet);
				
				HttpResponse httpResponse = this.httpClient.execute(httpHost, httpGet);
				
				if (flag) System.out.println(">>>>> httpResponse.getStatusLine()\n" + httpResponse.getStatusLine());
				if (flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));
				
				HttpEntity httpEntity = httpResponse.getEntity();
				entity = EntityUtils.toString(httpEntity);
				if (flag) System.out.println(">>>>> httpResponse.getEntity()\n" + entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
		}
	}
	
	private static HttpClientResponse instance = null;
	
	public synchronized static HttpClientResponse getInstance() {
		if (instance == null) {
			instance = new HttpClientResponse();
		}
		
		return instance;
	}
	
	public String get() {
		
		return null;
	}
	
	public String getReqStram(int idx) {
		String entity = null;

		if (flag) {
			// get stream
			try {
				HttpHost httpHost = new HttpHost("localhost", 8083, "http");
				HttpGet httpGet = new HttpGet("/generator/req/" + idx);
				if (!flag) System.out.printf(">>>>> [HttpHost:%s] [HttpGet:%s]%n", httpHost, httpGet);
				
				HttpResponse httpResponse = httpClient.execute(httpHost, httpGet);
				
				if (!flag) System.out.println(">>>>> httpResponse.getStatusLine()\n" + httpResponse.getStatusLine());
				if (!flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));
				
				HttpEntity httpEntity = httpResponse.getEntity();
				entity = EntityUtils.toString(httpEntity);
				if (!flag) System.out.println(">>>>> httpResponse.getEntity()\n" + entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return entity;
	}
}
