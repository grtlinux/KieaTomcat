package org.tain.sec04.exam02_file_copy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class FilesCopyMethodExample {

	public FilesCopyMethodExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path from = Paths.get("src/main/java/org/tain/sec04/exam02_file_copy/house1.jpg");
		Path to = Paths.get("src/main/java/org/tain/sec04/exam02_file_copy/house2.jpg");
		
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("파일 복사 성공");
	}
}
