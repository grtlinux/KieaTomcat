package org.tain.sec02.stream_kind;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FromDirectoryExample")
public class FromDirectoryExample {

	@SuppressWarnings("resource")
	public FromDirectoryExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path path = Paths.get("/Users/kangmac");
		Stream<Path> stream = Files.list(path);
		stream.forEach(a -> System.out.println(a.getFileName()));
		System.out.println();
	}
}
