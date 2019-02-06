package org.tain.sec04.exam02_fileinputstream;

import java.io.FileInputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FileInputStreamExample")
public class FileInputStreamExample {

	public FileInputStreamExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileInputStream fis = new FileInputStream("src/main/java/org/tain/sec04/exam02_fileinputstream/FileInputStreamExample.java");
		int data;
		while ( (data = fis.read() ) != -1 ) {
			System.out.write(data);
		}
		fis.close();	
	}
}
