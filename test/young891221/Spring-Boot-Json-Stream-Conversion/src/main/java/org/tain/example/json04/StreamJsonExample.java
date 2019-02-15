package org.tain.example.json04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "example.json04.StreamJsonExample")
public class StreamJsonExample {

	private static final boolean flag = true;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private StreamJsonProperty streamJsonProperty;
	
	private ObjectMapper objectMapper = null;
	
	@Bean
	public void test01() throws Exception {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + streamJsonProperty);
		}
		
		if (!flag) {
			/*
			 * This isn't running on executable jar. 
			 */
			Resource[] resources = null;
			// resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:**/*.json");  // ALL json in all jar files and this resources, for more study
			//resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:**/*.json");   // ALL json in this resources
			resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:templates/json/*.json");   // specified json files
			//resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:templates/json/MastInfo.json");   // the specified json file

			for (Resource resource : resources) {
				//System.out.println(">>>>> " + resource.getFilename());
				System.out.println(">>>>> " + resource.getFile().getCanonicalPath());
			}
		}
		
		if (flag) {
			
		}
	}
	
	@Bean
	public void test02() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		System.out.println(">>>>> " + new ClassPathResourceReader("templates/json/MastInfo.json").getContent());
		System.out.println(">>>>> " + new ClassPathResourceReader("templates/data/Request01(Euckr).dat").getContent());
	}

	private class ClassPathResourceReader {
		private final String path;
		private String content = null;
		
		public ClassPathResourceReader(String path) {
			this.path = path;
		}
		
		public String getContent() {
			if (this.content == null) {
				try {
					Resource resource = new ClassPathResource(this.path);
					BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
					content = reader.lines().collect(Collectors.joining("\n"));
					reader.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
			return this.content;
		}
	}
}




