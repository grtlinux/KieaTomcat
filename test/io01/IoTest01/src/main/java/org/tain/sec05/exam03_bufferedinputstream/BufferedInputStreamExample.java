package org.tain.sec05.exam03_bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "BufferedInputStreamExample")
public class BufferedInputStreamExample {

	public BufferedInputStreamExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream("src/main/java/org/tain/sec05/exam03_bufferedinputstream/forest.jpg");
		start = System.currentTimeMillis();
		while (fis1.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용하지 않았을 때: " + (end-start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream("src/main/java/org/tain/sec05/exam03_bufferedinputstream/forest.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while (bis.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("사용했을 때: " + (end-start) + "ms");
		bis.close();
		fis2.close();
	}
}
