package org.tain.sec04.exam03_fileoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FileOutputStreamExample")
public class FileOutputStreamExample {

	public FileOutputStreamExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		String originalFileName = "src/main/java/org/tain/sec04/exam03_fileoutputstream/house.jpg";
		String targetFileName = "/tmp/house.jpg";
		
		FileInputStream fis = new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo;
		byte[] readBytes = new byte[100];
		while ( (readByteNo = fis.read(readBytes)) != -1 ) {
			fos.write(readBytes, 0, readByteNo);
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("복사가 잘 되었습니다.");
	}
}
