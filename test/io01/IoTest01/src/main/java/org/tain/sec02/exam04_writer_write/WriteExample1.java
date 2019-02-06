package org.tain.sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam04.WriteExample1")
public class WriteExample1 {

	public WriteExample1() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Writer writer = new FileWriter("/Users/kangmac/_test.txt");
		char[] data = "홍길동".toCharArray();
		for(int i=0; i<data.length; i++) {
			writer.write(data[i]);
		}
		writer.flush();
		writer.close();
	}
}
