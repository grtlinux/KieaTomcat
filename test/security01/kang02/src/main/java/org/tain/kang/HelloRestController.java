package org.tain.kang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloRestController {

	private List<Map<String, Object>> repo;
	
	public HelloRestController() {
		this.repo = new ArrayList<>();
		
		for (int id=0; id < 10; id++) {
			Map<String, Object> map = new HashMap<>();
			
			map.put("id", new Integer(id));
			map.put("name", String.format("name%02d", id));
			map.put("content", String.format("this content's content-%05d", id));
			
			this.repo.add(map);
		}
	}
	
	@RequestMapping()
	public List<Map<String, Object>> list() {
		return this.repo;
	}
	
	@RequestMapping("/get")
	public Map<String, Object> get(@RequestParam(value="id", defaultValue="0") String id) {
		int idx = Integer.parseInt(id);
		if (idx < 0 || this.repo.size() <= idx)
			return new HashMap<>();
		
		return this.repo.get(idx);
	}
}
