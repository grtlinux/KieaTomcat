package org.tain.kang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloRestController {

	@RequestMapping()
	public List<Map<String, Object>> list() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		for (int i=0; i < 7; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", new Long(i+1));
			map.put("name", String.format("name-%d", i+1));
			map.put("email", String.format("kang-%d@email.com", i+1));
			list.add(map);
		}
		
		return list;
	}
	
	@RequestMapping("/get")
	public Map<String, Object> get() {
		int id = 123;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", new Long(id));
		map.put("name", String.format("name-%d", id));
		map.put("email", String.format("kang-%d@email.com", id));
		
		return map;
	}
}
