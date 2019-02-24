package org.tain.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.fep.http.FepHttp;
import org.tain.fep.info.ReqDataInfo;
import org.tain.fep.info.ReqFieldInfo;
import org.tain.fep.json.ReqStreamToJson;
import org.tain.utils.ClassUtil;

@RestController
@RequestMapping(value = {"/reqStream"})
public class ReqStreamController {

	private static final boolean flag = true;
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8085/reqStream/list
	@GetMapping(value = {"/list"})
	public String list() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8084/reqStream/list");
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8085/reqStream/size
	@GetMapping(value = {"/size"})
	public String size() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8084/reqStream/size");
	}

	// curl -H 'Content-Type: application/json' -X POST -d '{"index":0}' http://localhost:8085/reqStream/info
	//@RequestMapping(value = "/info", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		if (flag) System.out.println(">>>>> httpEntity.getBody() : " + httpEntity.getBody());
		String json = FepHttp.getInstance().post("http://localhost:8084/reqStream/info", httpEntity.getBody());
		
		Map<?,?> map = FepHttp.getInstance().getMap(json);
		if (flag) System.out.println(">>>>> map : " + map);
		
		String dataStream = (String) map.get("dataStream");
		if (flag) System.out.println(">>>>> dataStream : " + dataStream);
		
		return streamToJson(dataStream);
	}
	
	private String streamToJson(String dataStream) throws Exception {
		if (flag) System.out.println(">>>>> dataStream : [" + dataStream + "]");
		
		ReqFieldInfo reqFieldInfo = ReqStreamToJson.getInstance().getReqFieldInfo(dataStream);
		ReqDataInfo reqDataInfo = ReqStreamToJson.getInstance().getReqDataInfo(reqFieldInfo);
		
		String json = FepHttp.getInstance().getJson(reqDataInfo);
		if (flag) System.out.println(">>>>> json : -> json " + json);
		return json;
	}
}
