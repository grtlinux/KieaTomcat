package org.tain.sec05.exam04_bufferedreader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "BufferedReaderExample")
public class BufferedReaderExample {

	private static final boolean flag = true;
	
	public BufferedReaderExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		if (flag) return;
		
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);	
		BufferedReader br = new BufferedReader(reader);
		
		System.out.print("입력: ");
		String lineString = br.readLine();
		
		System.out.println("출력: " + lineString);	
	}
}
