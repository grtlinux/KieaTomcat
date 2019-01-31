package org.tain.json02;

import java.io.File;

import org.springframework.stereotype.Component;
import org.tain.fep.Fep;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReadJson2 {
	
	public ReadJson2() throws Exception {
		readJson();
	}

	public void readJson() throws Exception {
		System.out.println(">>>>> ReadJson.readJson....");
		
		ObjectMapper objectMapper = new ObjectMapper();
		Fep fep = objectMapper.readValue(new File("/users/kangmac/FEP01.json"), Fep.class);
		
		System.out.println(">>>>> " + fep);
	}
}
