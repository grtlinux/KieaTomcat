package org.tain.sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam01.ReadExample1")
public class ReadExample1 {

	public ReadExample1() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		InputStream is = new FileInputStream("/Users/kangmac/FEP01.json");
		int readByte;
		while (true) {
			readByte = is.read();
			if (readByte == -1)
				break;
			System.out.print((char) readByte);
		}
		is.close();
	}
}
