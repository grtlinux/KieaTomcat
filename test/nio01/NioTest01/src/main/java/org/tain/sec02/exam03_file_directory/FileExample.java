package org.tain.sec02.exam03_file_directory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class FileExample {

	public FileExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path path = Paths.get("src/main/java/org/tain/sec02/exam03_file_directory/FileExample.java");
		System.out.println("디렉토리 여부: " + Files.isDirectory(path));
		System.out.println("파일 여부: " + Files.isRegularFile(path));
		System.out.println("마지막 수정 시간: " + Files.getLastModifiedTime(path));
		System.out.println("파일 크기: " + Files.size(path));
		System.out.println("소유자: " + Files.getOwner(path).getName());
		System.out.println("숨김 파일 여부: " + Files.isHidden(path));
		System.out.println("읽기 기능 여부: " + Files.isReadable(path));
		System.out.println("쓰기 가능 여부: " + Files.isWritable(path));
	}
}
