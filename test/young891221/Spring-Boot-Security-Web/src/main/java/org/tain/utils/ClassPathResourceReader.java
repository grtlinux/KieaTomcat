package org.tain.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ClassPathResourceReader {

	private static boolean flag = true;

	private ClassPathResourceReader() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}

	public String getContent(String filePath) {
		String content = null;

		try {
			Resource resource = new ClassPathResource(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			content = reader.lines().collect(Collectors.joining("\n"));
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return content;
	}

	public List<String> getList(String filePath) {
		List<String> list = new ArrayList<>();

		try {
			Resource resource = new ClassPathResource(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "EUC-KR"));
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	///////////////////////////////////////////////////////////////////

	private static ClassPathResourceReader instance = null;

	public synchronized static ClassPathResourceReader getInstance() {
		if (instance == null) {
			instance = new ClassPathResourceReader();
		}
		return instance;
	}
}
