package org.tain.example.resource01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.tain.utils.ClassUtil;

@Component(value = "example.resource01.ResourcesExample")
public class ResourcesExample {

	private static final boolean flag = true;
	
	@Bean
	public void test01() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		ClassPathResource classPathResource = new ClassPathResource("static/static.txt");
		
		byte[] byteStatic = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
		String strStatic = new String(byteStatic, StandardCharsets.UTF_8);
		System.out.println(">>>>> " + strStatic);
	}
	
	@Bean
	public void test02() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (!flag) {
			Resource resource = new ClassPathResource("templates/templates.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(">> " + line);
			}
			bufferedReader.close();
		} else {
			Resource resource = new ClassPathResource("templates/templates.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			bufferedReader.lines().forEach(System.out::println);
		}
	}
	
	@Bean
	public void test03() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		System.out.println(">>>>> " + new ClassPathResourceReader("templates/templates.txt").getContent());
	}
	
	private static class ClassPathResourceReader {
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
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Bean
	public void test04() throws Exception {
		// classpath*:../../json/*.json    <- OK
		Resource[] resources = null;
		resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:**/*.json");  // ALL json in all jar files and this resources
		resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:**/*.json");   // ALL json in this resources
		resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:templates/json/*.json");   // specified json files
		resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:templates/json/MastInfo.json");   // the specified json file

		if (flag) {
			for (Resource resource : resources) {
				System.out.println(">>>>> " + resource.getFile().getName());
			}
		}
		
		if (!flag) {
			for (int i=0; i < resources.length; i++) {
				System.out.println(">>>>> " + resources[i].getFilename());
			}
		}
		
		if (!flag) {
			for (Resource resource : resources) {
				System.out.println(">>>>> " + resource.getFilename() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				InputStream is = resource.getInputStream();
				byte[] byteJson = IOUtils.toByteArray(is);
				String strJson = new String(byteJson, Charset.forName("UTF-8"));
				System.out.println(">>>>> " + strJson);
			}
		}
	}
}





