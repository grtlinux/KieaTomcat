package org.tain.sec02.exam03_file_directory;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class DirectoryExample {

	public DirectoryExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path path1 = Paths.get("/Users/kangmac/_subdir");
		Path path2 = Paths.get("/Users/kangmac/_file.txt");
		
		if(Files.notExists(path1)) {
			Files.createDirectories(path1);
		}
		
		if(Files.notExists(path2)) {
			Files.createFile(path2);
		}
		
		Path path3 = Paths.get("/Users/kangmac/Sublime Text");
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);
		for(Path path : directoryStream) {
			if(Files.isDirectory(path)) {
				System.out.println("[디렉토리] " + path.getFileName());
			} else {
				System.out.println("[파일] " + path.getFileName() + " (크기):" + Files.size(path) + ")");
			}
		}
	}
}
