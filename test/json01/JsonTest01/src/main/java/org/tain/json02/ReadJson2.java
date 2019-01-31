package org.tain.json02;

import org.springframework.stereotype.Component;
import org.tain.fep.Fep;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReadJson2 {
	
	public ReadJson2() throws Exception {
		readJson();
	}

	public void readJson() throws Exception {
		System.out.println(">>>>> ReadJson2.readJson....");
		
		ObjectMapper objectMapper = new ObjectMapper();
		Fep fep = objectMapper.readValue(getClass().getResourceAsStream("/FEP01.json"), Fep.class);
		
		System.out.println(">>>>> " + fep);
	}
}
