package org.tain.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * TODO KANG-20190217: to static class
 */
public class ClassPathResourceReader {
	
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
