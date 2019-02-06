package org.tain.sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam01.ReadExample3")
public class ReadExample3 {

	public ReadExample3() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		InputStream is = new FileInputStream("/Users/kangmac/FEP01.json");
		@SuppressWarnings("unused")
		int readByteNo;
		byte[] readBytes = new byte[8];
		readByteNo = is.read(readBytes, 2, 3);
		for(int i=0; i<readBytes.length; i++) {
			System.out.println(readBytes[i]);
		}
		is.close();
	}
}
