package org.tain.sec04.exam04_file_reader;

import java.io.FileReader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FileReaderExample")
public class FileReaderExample {

	public FileReaderExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileReader fr = new FileReader("src/main/java/org/tain/sec04/exam04_file_reader/FileReaderExample.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		}
		fr.close();
	}
}
