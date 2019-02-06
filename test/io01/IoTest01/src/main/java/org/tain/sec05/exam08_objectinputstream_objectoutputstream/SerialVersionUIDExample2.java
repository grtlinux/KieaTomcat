package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SerialVersionUIDExample2")
public class SerialVersionUIDExample2 {

	public SerialVersionUIDExample2() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileInputStream fis = new FileInputStream("/Users/kangmac/_Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ClassC classC = (ClassC) ois.readObject();
		System.out.println("field1: " + classC.field1);
		ois.close();
	}
}
