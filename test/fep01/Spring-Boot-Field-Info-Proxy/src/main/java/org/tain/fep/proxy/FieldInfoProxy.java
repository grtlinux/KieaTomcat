package org.tain.fep.proxy;

import org.tain.utils.ClassUtil;

public class FieldInfoProxy {

	private static final boolean flag = true;
	
	//private static Map<String, String> mapFieldInfo = new HashMap<>();
	
	public FieldInfoProxy() { }
	
	// TODO KANG-20190220: NOT USED
	public synchronized static String get(String infoKey) {
		if (flag) System.out.printf(">>>>> [infoKey=%s] %s%n", infoKey, ClassUtil.getClassInfo());
		
		String ret = null;
		
//		if (infoKey == null || "".equals(infoKey.trim()))
//			return null;
//		
//		ret = mapFieldInfo.get(infoKey);
//		if (ret == null) {
//			// get FieldInfo from Field-Info-Server
//			HttpClient httpClient = HttpClientBuilder.create().build();
//			try {
//				HttpHost httpHost = new HttpHost("localhost", 8081, "http");
//				HttpGet httpGet = new HttpGet("/field/" + infoKey);
//				if (flag) System.out.printf(">>>>> [HttpHost:%s] [HttpGet:%s]%n", httpHost, httpGet);
//				
//				HttpResponse httpResponse = httpClient.execute(httpHost, httpGet);
//				
//				if (flag) System.out.println(">>>>> httpResponse.getStatusLine()\n" + httpResponse.getStatusLine());
//				if (flag) System.out.println(">>>>> httpResponse.getAllHeaders()\n" + Arrays.asList(httpResponse.getAllHeaders()));
//				
//				HttpEntity httpEntity = httpResponse.getEntity();
//				ret = EntityUtils.toString(httpEntity);
//				if (flag) System.out.println(">>>>> httpResponse.getEntity()\n" + ret);
//				
//				mapFieldInfo.put(infoKey, ret);
//			} catch (Exception e) {
//				e.printStackTrace();
//				ret = null;
//			}
//		}
		
		return ret;
	}
}
