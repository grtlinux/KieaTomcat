package org.tain.verify.exam07;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "AddLineNumberExample")
public class AddLineNumberExample {

	public AddLineNumberExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		String filePath = "src/main/java/org/tain/sec05/exam04_bufferedreader/BufferedReaderExample.java";

		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);

		int rowNumber = 0;
		String rowData;
		while( (rowData=br.readLine())!= null ) {
			System.out.println(++rowNumber + ": " + rowData);
		}

		br.close(); fr.close();
	}
}
