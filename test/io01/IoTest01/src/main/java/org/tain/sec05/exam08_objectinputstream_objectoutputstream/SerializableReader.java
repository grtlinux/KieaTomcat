package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SerializableReader")
public class SerializableReader {

	public SerializableReader() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileInputStream fis = new FileInputStream("/Users/kangmac/_Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ClassA v = (ClassA) ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2.field1: " + v.field2.field1);
		System.out.println("field3: " + v.field3);
		System.out.println("field4: " + v.field4);
		ois.close();
	}
}
