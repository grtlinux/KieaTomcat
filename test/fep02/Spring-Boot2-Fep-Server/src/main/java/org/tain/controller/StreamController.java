package org.tain.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.fep.info.ResDataInfo;
import org.tain.fep.info.ResFieldInfo;
import org.tain.fep.json.ResStreamToJson;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/stream"})
public class StreamController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"index":0}' http://localhost:8089/stream/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		String json = FepHttp.getInstance().post("http://localhost:8092/resStream/info", httpEntity.getBody());
		
		Map<?,?> map = FepHttp.getInstance().getMap(json);
		if (flag) System.out.println(">>>>> map : " + map);
		
		String dataStream = (String) map.get("dataStream");
		if (flag) System.out.println(">>>>> dataStream : " + dataStream);
		
		return streamToJson(dataStream);
	}
	
	private String streamToJson(String dataStream) throws Exception {
		if (flag) System.out.println(">>>>> dataStream : [" + dataStream + "]");
		
		ResFieldInfo resFieldInfo = ResStreamToJson.getInstance().getResFieldInfo(dataStream);
		ResDataInfo resDataInfo = ResStreamToJson.getInstance().getResDataInfo(resFieldInfo);
		
		String json = FepHttp.getInstance().getJson(resDataInfo);
		if (flag) System.out.println(">>>>> json : -> json " + json);
		return json;
	}
}
