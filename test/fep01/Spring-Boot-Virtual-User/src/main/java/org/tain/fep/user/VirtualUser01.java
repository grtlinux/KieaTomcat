package org.tain.fep.user;

import java.util.HashMap;
import java.util.Map;

import org.tain.fep.http.FepHttp;
import org.tain.fep.info.GetFieldInfo;
import org.tain.fep.info.ReqDataInfo;
import org.tain.fep.info.ReqFieldInfo;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

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
			String reqStream1 = null;
			ReqFieldInfo reqFieldInfo1;
			ReqDataInfo reqDataInfo;
			ReqFieldInfo reqFieldInfo2;
			String reqStream2 = null;
			
			if (flag) {
				// to get Request Stream.
				reqStream1 = getReqStream(idx).replace('.', ' ');
				if (flag) System.out.println(">>>>> reqStream1: [" + reqStream1 + "]");
			}
			
			if (flag) {
				// to get reqFieldInfo
				reqFieldInfo1 = GetFieldInfo.getInstance().getReqFieldInfo(reqStream1);
			}
			
			if (flag) {
				// to get reqDataInfo
				reqDataInfo = GetFieldInfo.getInstance().getReqDataInfo(reqFieldInfo1);
			}
			
			if (flag) {
				// to get getFieldInfo
				reqFieldInfo2 = GetFieldInfo.getInstance().getReqFieldInfo(reqDataInfo);
			}
			
			if (flag) {
				// to get Request stream.
				reqStream2 = GetFieldInfo.getInstance().getStream(reqFieldInfo2);
			}
			
			if (flag) {
				// print reqStream2
				if (flag) System.out.println(">>>>> reqStream2: [" + reqStream2 + "]");
			}
			
			Sleep.run(2000);
		}
	}
	
	private String getReqStream(int idx) throws Exception {
		String ret = null;
		
		if (!flag) {
			Map<String, Object> params = new HashMap<>();
			params.put("index", (Integer) idx);
			String json = this.objectMapper.writeValueAsString(params);
			if (!flag) System.out.println(">>>>> req json: " + json);
			
			ret = FepHttp.getInstance().post("http://localhost:8083/reqGen/data", json);
			if (!flag) System.out.println(">>>>> res json: " + ret);
		} else if (flag) {
			String json = FepHttp.getInstance().post("http://localhost:8083/reqGen/data", String.format("{\"index\":%d}", idx));
			if (!flag) System.out.println(">>>>> res json: " + json);
			Map<?, ?> map = this.objectMapper.readValue(json, Map.class);
			ret = (String) map.get("dataStream");
		}
		
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
