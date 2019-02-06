package org.tain.sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam03.ReadExample2")
public class ReadExample2 {

	public ReadExample2() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Reader reader = new FileReader("/Users/kangmac/_test.txt");
		int readCharNo;
		char[] cbuf = new char[2];
		String data = "";
		while( true ) {
			readCharNo = reader.read(cbuf);
			if(readCharNo == -1) break;
			data += new String(cbuf, 0, readCharNo);
		}
		System.out.println(data);
		
		reader.close();
	}
}
