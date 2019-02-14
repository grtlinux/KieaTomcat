package org.tain.example.json01;

import java.io.File;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

//@Component(value = "example.json01.StreamJsonExample")
public class StreamJsonExample {

	private static final boolean flag = true;
	
	@Autowired
	private StreamJsonProperty streamJsonProperty;
	
	@Bean(value = "example.svr01.ServerExample.test01")
	public void test01() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + streamJsonProperty);
		}
		
		if (flag) {
			// json to object
			try {
				ObjectMapper mapper = new ObjectMapper();
				
				MyValue myValue = null;
				// myValue = mapper.readValue(new URL("http://localhost:8081/api/json/_data.json"), MyValue.class); // OK after connection
				myValue = mapper.readValue(new File("/Users/kangmac/STS_GIT/_data.json"), MyValue.class); // OK
				myValue = mapper.readValue(new File(new URI("file:///Users/kangmac/STS_GIT/_data.json")), MyValue.class); // OK
				myValue = mapper.readValue(new ClassPathResource("templates/_data.json").getFile(), MyValue.class); // OK
				myValue = mapper.readValue(ResourceUtils.getFile("classpath:templates/_data.json"), MyValue.class); // OK
				myValue = mapper.readValue("{\"name\":\"Bob\",\"age\":33}", MyValue.class); // OK
				
				System.out.println(">>>>> " + myValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (flag) {
			// object to json
			try {
				MyValue myValue = new MyValue();
				myValue.setName("Hello, world!!");
				myValue.setAge(22);
				
				ObjectMapper mapper = new ObjectMapper();  // create once, reuse
				mapper.writeValue(new File("/Users/kangmac/STS_GIT/_data2.json"), myValue);  // OK
				//mapper.writeValue(new File(new URI("file:///Users/kangmac/STS_GIT/_data2.json")), myValue); // OK
				//mapper.writeValue(new ClassPathResource("templates/_data2.json").getFile(), myValue);  // ERROR: FileNotFoundException
				//mapper.writeValue(ResourceUtils.getFile("classpath:templates/_data2.json"), myValue);  // ERROR: FileNotFoundException
				//mapper.writeValue(ResourceUtils.getFile("classpath:_data3.json"), myValue);  // ERROR: FileNotFoundException
				
				byte[] jsonBytes = mapper.writeValueAsBytes(myValue);
				System.out.println(">>>>> " + new String(jsonBytes));
				String jsonString = mapper.writeValueAsString(myValue);
				System.out.println(">>>>> " + jsonString);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (flag) {
			// pretty print
			try {
				MyValue myValue = new MyValue();
				myValue.setName("Hello, world!!");
				myValue.setAge(33);
				
				ObjectMapper mapper = new ObjectMapper();  // create once, reuse
				String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(myValue);
				System.out.println(">>>>> " + jsonString);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * success ok! on static inner class 'StreamJsonExample.MyValue'
	 */
//	@Data
//	private static class MyValue {
//		private String name;
//		private Integer age;
//	}
}

/*
 * success ok! on public class 'MyValue'
 */
@Data
class MyValue {
	private String name;
	private Integer age;
}


