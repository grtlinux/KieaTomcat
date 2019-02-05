package org.tain.sec02.stream_kind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FromFileContentExample")
public class FromFileContentExample {

	@SuppressWarnings("resource")
	public FromFileContentExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path path = Paths.get("src/main/java/org/tain/sec02/stream_kind/linedata.txt");
		Stream<String> stream;
		
		//Files.lines() 메소드 이용
		// Charset.forName("UTF-8")
		// Charset.forName("EUC-KR")
		stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach( System.out::println );
		stream.close();
		System.out.println("----------------------------");
		
		//BufferedReader의 lines() 메소드 이용
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		stream = br.lines();
		stream.forEach( System.out::println );
		stream.close();
		System.out.println("----------------------------");
	}
}
