package org.tain.sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam02.WriteExample1")
public class WriteExample1 {

	public WriteExample1() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		OutputStream os = new FileOutputStream("/Users/kangmac/_test.txt");
		byte[] data = "ABC".getBytes();
		for(int i=0; i<data.length; i++) {
			os.write(data[i]);
		}
		os.flush();
		os.close();
	}
}
