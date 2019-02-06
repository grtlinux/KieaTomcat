package org.tain.sec04.exam05_file_writer;

import java.io.File;
import java.io.FileWriter;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "FileWriterExample")
public class FileWriterExample {

	public FileWriterExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		File file = new File("/Users/kangmac/_file.txt");	
		FileWriter fw = new FileWriter(file, true);		
		fw.write("FileWriter는 한글로된 " + "\r\n");
		fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
		fw.flush();
		fw.close();
		System.out.println("파일에 저장되었습니다.");
	}
}
