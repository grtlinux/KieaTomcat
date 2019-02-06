package org.tain.sec05.exam05_bufferedoutputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "BufferedOutputStreamExample")
public class BufferedOutputStreamExample {

	public BufferedOutputStreamExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		
		
		
		fis = new FileInputStream("src/main/java/org/tain/sec05/exam05_bufferedoutputstream/forest.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("/Users/kangmac/_forest1.jpg");				
		start = System.currentTimeMillis();
		while ((data = bis.read()) != -1) {
			fos.write(data);
		}
		fos.flush();
		end = System.currentTimeMillis();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용하지 않았을 때: " + (end-start) + "ms");
		
		
		
		fis = new FileInputStream("src/main/java/org/tain/sec05/exam05_bufferedoutputstream/forest.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("/Users/kangmac/_forest2.jpg");		
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();
		while ((data = bis.read()) != -1) {
			bos.write(data);
		}
		bos.flush();
		end = System.currentTimeMillis();
		bos.close();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용했을 때: " + (end-start) + "ms");
	}
}
