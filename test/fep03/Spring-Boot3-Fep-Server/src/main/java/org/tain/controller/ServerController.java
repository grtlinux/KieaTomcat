package org.tain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tain.domain.Item01;
import org.tain.domain.Item23;
import org.tain.domain.Mast;
import org.tain.domain.Store;
import org.tain.fep.http.FepHttp;
import org.tain.repository.Item01Repository;
import org.tain.repository.Item23Repository;
import org.tain.repository.MastRepository;
import org.tain.repository.StoreRepository;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = {"/server"})
public class ServerController {

	private static final boolean flag = true;
	
	private ObjectMapper objectMapper = null;
	
	public ServerController() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		this.objectMapper = new ObjectMapper();
	}
	
	@GetMapping(value = {"/"})
	public String hello() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		return "Hello, world!!!!";
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8082/fieldInfo/list
	@GetMapping(value = {"/list"})
	public String list() throws Exception {
		return FepHttp.getInstance().get("http://localhost:8082/fieldInfo/list");
	}
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8082/fieldInfo/info
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String info(HttpEntity<String> httpEntity) throws Exception {
		return FepHttp.getInstance().post("http://localhost:8082/fieldInfo/info", httpEntity.getBody());
	}
	
	// curl -H 'Content-Type: application/json' -X GET http://localhost:8082/fieldInfo/MastInfo
	@GetMapping(value = {"/{name}"})
	public String field(@PathVariable("name") String name) throws Exception {
		return FepHttp.getInstance().get("http://localhost:8082/fieldInfo/" + name);
	}

	//////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private MastRepository mastRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private Item01Repository item01Repository;
	@Autowired
	private Item23Repository item23Repository;
	
	// curl -H 'Content-Type: application/json' -X POST -d '{"infoKey":"MastInfo"}' http://localhost:8082/fieldInfo/info
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpEntity<String> httpEntity) throws Exception {
		String jsonData = httpEntity.getBody();
		if (flag) System.out.println(">>>>> ServerController.jsonData REQ = " + jsonData);
		
		JsonNode dataNode = this.objectMapper.readTree(jsonData);
		if (flag) System.out.println(">>>>> ServerController.dataNode REQ = " + this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataNode));
		
		String mastJson = this.objectMapper.writeValueAsString(dataNode.path("mastData"));
		String storeJson = this.objectMapper.writeValueAsString(dataNode.path("storeData"));
		String item01Json = this.objectMapper.writeValueAsString(dataNode.path("item01Data"));
		String item23Json = this.objectMapper.writeValueAsString(dataNode.path("item23Data"));
		
		if (flag) System.out.println(">>>>> ServerController.mastJson : " + mastJson);
		if (flag) System.out.println(">>>>> ServerController.storeJson : " + storeJson);
		if (flag) System.out.println(">>>>> ServerController.item01Json : " + item01Json);
		if (flag) System.out.println(">>>>> ServerController.item23Json : " + item23Json);
		
		Mast mast = this.objectMapper.readValue(mastJson, Mast.class);
		Store store = this.objectMapper.readValue(storeJson, Store.class);
		List<Item01> listItem01 = this.objectMapper.readValue(item01Json, new TypeReference<List<Item01>>(){});
		Item23 item23 = this.objectMapper.readValue(item23Json, Item23.class);
		
		this.mastRepository.save(mast);
		this.storeRepository.save(store);
		for (Item01 item01 : listItem01) {
			this.item01Repository.save(item01);
		}
		this.item23Repository.save(item23);
		
		return String.format("{\"status\": \"%04d\"}", 0);
	}
}
