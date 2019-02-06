package org.tain.sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam04.WriteExample3")
public class WriteExample3 {

	public WriteExample3() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Writer writer = new FileWriter("/Users/kangmac/_test.txt");
		char[] data = "홍길동".toCharArray();
		writer.write(data, 1, 2);

		writer.flush();
		writer.close();
	}
}
