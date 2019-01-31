package org.tain.json01;

import java.io.File;

import org.springframework.stereotype.Component;
import org.tain.fep.Fep;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReadJson1 {
	
	public ReadJson1() throws Exception {
		readJson();
	}

	public void readJson() throws Exception {
		System.out.println(">>>>> ReadJson1.readJson....");
		
		ObjectMapper objectMapper = new ObjectMapper();
		Fep fep = objectMapper.readValue(new File("/users/kangmac/FEP01.json"), Fep.class);
		
		System.out.println(">>>>> " + fep);
	}
}
