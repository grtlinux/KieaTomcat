package org.tain.sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam01.ReadExample2")
public class ReadExample2 {

	public ReadExample2() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		InputStream is = new FileInputStream("/Users/kangmac/FEP01.json");
		int readByteNo;
		byte[] readBytes = new byte[3];
		String data = "";
		while (true) {
			readByteNo = is.read(readBytes);
			if (readByteNo == -1)
				break;
			data += new String(readBytes, 0, readByteNo);
		}
		System.out.println(data);
		is.close();
	}
}
