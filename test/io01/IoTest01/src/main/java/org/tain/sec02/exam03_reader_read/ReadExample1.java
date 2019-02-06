package org.tain.sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam03.ReadExample1")
public class ReadExample1 {

	public ReadExample1() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Reader reader = new FileReader("/Users/kangmac/_test.txt");
		int readData;
		while( true ) {
			readData = reader.read();
			if(readData == -1) break;
			System.out.print((char)readData);
		}
		
		reader.close();
	}
}
