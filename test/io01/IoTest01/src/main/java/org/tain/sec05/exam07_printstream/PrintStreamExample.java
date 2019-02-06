package org.tain.sec05.exam07_printstream;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "PrintStreamExample")
public class PrintStreamExample {

	public PrintStreamExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileOutputStream fos = new FileOutputStream("/Users/kangmac/_file.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.println("[프린터 보조 스트림]");
		ps.print("마치 ");
		ps.println("프린터가 출력하는 것처럼 ");
		ps.println("데이터를 출력합니다.");
		
		ps.flush();
		ps.close();
		fos.close();
	}
}
