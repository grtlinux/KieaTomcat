package org.tain.sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam03.ReadExample3")
public class ReadExample3 {

	public ReadExample3() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Reader reader = new FileReader("/Users/kangmac/_test.txt");
		int readCharNo;
		char[] cbuf = new char[4];
		readCharNo = reader.read(cbuf, 1, 2);
		for(int i=0; i<cbuf.length; i++) {
			System.out.println(cbuf[i]);
		}
		reader.close();
	}
}
