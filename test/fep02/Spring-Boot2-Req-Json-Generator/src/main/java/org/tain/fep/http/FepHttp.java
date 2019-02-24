package org.tain.fep.http;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FepHttp {

	private static final boolean flag = true;

	private HttpClient httpClient;
	private Map<String, String> mapInfo;
	private ObjectMapper objectMapper;

	private FepHttp() {
		this.httpClient = HttpClientBuilder.create().build();
		this.mapInfo = new HashMap<>();
		this.objectMapper = new ObjectMapper();
	}

	public String post(String url, String json) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		String ret = null;

		if (flag) {
			HttpResponse httpResponse = null;

			try {
				HttpPost httpPost = new HttpPost(url);
				httpPost.addHeader("content-type", "application/json");
				httpPost.setEntity(new StringEntity(json));
				// StringEntity params = new StringEntity(json);
				// httpPost.setEntity(params);
				httpResponse = this.httpClient.execute(httpPost);
			} catch (Exception e) {
				e.printStackTrace();
				ret = null;
			} finally {
				//Deprecated
				//httpClient.getConnectionManager().shutdown();
			}

			if (!flag) System.out.println(">>>>> status : " + httpResponse.getStatusLine());
			if (!flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));

			HttpEntity httpEntity = httpResponse.getEntity();
			ret = EntityUtils.toString(httpEntity);
		}

		return ret;
	}

	public String get(String url) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		String ret = null;

		if (flag) {
			HttpResponse httpResponse = null;

			try {
				HttpGet httpGet = new HttpGet(url);
				httpGet.addHeader("content-type", "application/json");
				// StringEntity params = new StringEntity(json);
				// httpPost.setEntity(params);
				httpResponse = this.httpClient.execute(httpGet);
			} catch (Exception e) {
				e.printStackTrace();
				ret = null;
			} finally {
				//Deprecated
				//httpClient.getConnectionManager().shutdown();
			}

			if (!flag) System.out.println(">>>>> status : " + httpResponse.getStatusLine());
			if (!flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));

			HttpEntity httpEntity = httpResponse.getEntity();
			ret = EntityUtils.toString(httpEntity);
		}

		return ret;
	}

	public Map<?,?> getMap(String json) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		Map<?, ?> map = this.objectMapper.readValue(json, Map.class);

		return map;
	}

	public String getJson(Map<?,?> map) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		String json = this.objectMapper.writeValueAsString(map);

		return json;
	}

	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////

	public String postInfo(String url, String json) throws Exception {

		String ret = null;
		String infoKey = null;

		if (flag) {
			Map<?, ?> map = this.objectMapper.readValue(json, Map.class);
			infoKey = (String) map.get("infoKey");
			if (infoKey == null)
				throw new RuntimeException("ERROR: there is no infoKey....");
		}

		if (flag) {
			ret = this.mapInfo.get(infoKey);
			if (ret != null)
				return ret;
		}

		if (flag) {
			HttpResponse httpResponse = null;

			try {
				HttpPost httpPost = new HttpPost(url);
				httpPost.addHeader("content-type", "application/json");
				httpPost.setEntity(new StringEntity(json));
				// StringEntity params = new StringEntity(json);
				// httpPost.setEntity(params);
				httpResponse = this.httpClient.execute(httpPost);
			} catch (Exception e) {
				e.printStackTrace();
				ret = null;
			} finally {
				//Deprecated
				//httpClient.getConnectionManager().shutdown();
			}

			if (!flag) System.out.println(">>>>> status : " + httpResponse.getStatusLine());
			if (!flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));

			HttpEntity httpEntity = httpResponse.getEntity();
			ret = EntityUtils.toString(httpEntity);

			/*
			// OK
			StringBuffer stringBuffer = new StringBuffer();
			if (httpEntity != null) {
				if (flag) System.out.println(">>>>> response length: " + httpEntity.getContentLength());
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuffer.append(line);
				}
				reader.close();
			}
			ret = stringBuffer.toString();
			*/
		}

		if (flag) {
			this.mapInfo.put(infoKey, ret);
		}

		return ret;
	}

	public String getList(String url) {
		String ret = null;

		try {
			HttpGet httpGet = new HttpGet(url);
			if (!flag) System.out.printf(">>>>> [HttpGet:%s]%n", httpGet);

			HttpResponse httpResponse = httpClient.execute(httpGet);

			if (!flag) System.out.println(">>>>> httpResponse.getStatusLine()\n" + httpResponse.getStatusLine());
			if (!flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));

			HttpEntity httpEntity = httpResponse.getEntity();
			ret = EntityUtils.toString(httpEntity);
			if (!flag) System.out.println(">>>>> httpResponse.getEntity()\n" + ret);
		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}

		return ret;
	}

	//////////////////////////////////////////

	private static FepHttp instance = null;

	public static FepHttp getInstance() {

		if (instance == null) {
			instance = new FepHttp();
		}

		return instance;
	}
}
