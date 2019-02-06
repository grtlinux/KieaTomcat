package org.tain.sec05.exam01_inputstreamreader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "InputStreamReaderExample")
public class InputStreamReaderExample {

	private static final boolean flag = true;
	
	public InputStreamReaderExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
	
		if (flag) return;
		
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);	
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo=reader.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.println(data);
		}
		// ctrl + D for quit
		
		reader.close();
	}
}
