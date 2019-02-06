package org.tain.sec05.exam02_outputstreamwriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "OutputStreamWriterExample")
public class OutputStreamWriterExample {

	public OutputStreamWriterExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileOutputStream fos = new FileOutputStream("/Users/kangmac/_file5.txt");
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "바이트 출력 스트림을 문자 출력 스트림으로 변환";
		writer.write(data);
		
		writer.flush();
		writer.close();
		System.out.println("파일 저장이 끝났습니다.");
	}
}
