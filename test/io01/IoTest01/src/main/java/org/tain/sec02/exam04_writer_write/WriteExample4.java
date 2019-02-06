package org.tain.sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam04.WriteExample4")
public class WriteExample4 {

	public WriteExample4() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Writer writer = new FileWriter("/Users/kangmac/_test.txt");
		
		String data = "안녕 자바 프로그램";
		//writer.write(data);
		writer.write(data, 3, 2);
		
		writer.flush();
		writer.close();
	}
}
