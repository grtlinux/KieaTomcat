package org.tain.fep.user;

import java.util.HashMap;
import java.util.Map;

import org.tain.fep.http.FepHttp;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VirtualUser01 {

	private static final boolean flag = true;
	
	private ObjectMapper objectMapper;
	
	private VirtualUser01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		this.objectMapper = new ObjectMapper();
	}
	
	public void process01() throws Exception {
		
		//int[] arrIndex = new int[] { 0, 1, 2, 3 };
		int[] arrIndex = new int[] { 0 };
		for (int idx : arrIndex ) {
			String reqStream = null;
			
			if (flag) {
				// to get Request Stream.
				reqStream = getReqStream(idx).replace('.', ' ');
				if (flag) System.out.println(">>>>> reqStream: [" + reqStream + "]");
			}
			
			if (flag) {
				// to get reqFieldInfo
			}
			
			if (flag) {
				// to get reqFieldData
			}
		}
	}
	
	private String getReqStream(int idx) throws Exception {
		String ret = null;
		
		Map<String, Object> params = new HashMap<>();
		params.put("index", (Integer) idx);
		String json = this.objectMapper.writeValueAsString(params);
		if (!flag) System.out.println(">>>>> req json: " + json);
		
		ret = FepHttp.getInstance().post("http://localhost:8083/reqGen/data", json);
		if (!flag) System.out.println(">>>>> res json: " + ret);
		
		return ret;
	}

	////////////////////////////////////////////////
	
	private static VirtualUser01 instance;
	
	public synchronized static VirtualUser01 getInstance() {
		if (instance == null) {
			instance = new VirtualUser01();
		}
		
		return instance;
	}
}
