package org.tain.fep.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "fep.test.FileCharsetTest")
public class FileCharsetTest {

	private static final boolean flag = true;
	
	private static final String FILE_PATH = "templates/data/Request01(Euckr).dat";
	
	@Bean(value = "fep.test.FileCharsetTest.test01")
	public void test01() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) {
			Resource resource = new ClassPathResource(FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "EUC-KR"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(">>>>> " + line);
			}
			bufferedReader.close();
		}
		
		if (flag) {
			/*
			Resource resource = new ClassPathResource(FILE_PATH);
			List<String> list = Files.readLines(resource.getFile(), Charset("UTF-8"));
			
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "EUC-KR"));
			bufferedReader.lines().collect(collector)
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(">>>>> " + line);
			}
			bufferedReader.close();
			*/
		}
	}
}
