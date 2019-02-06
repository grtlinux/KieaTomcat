package org.tain.sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam02.WriteExample2")
public class WriteExample2 {

	public WriteExample2() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		OutputStream os = new FileOutputStream("/Users/kangmac/_test.txt");
		byte[] data = "ABC".getBytes();
		os.write(data);
		os.flush();
		os.close();
	}
}
