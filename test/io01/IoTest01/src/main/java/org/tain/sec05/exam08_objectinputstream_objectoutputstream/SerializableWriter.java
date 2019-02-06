package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SerializableWriter")
public class SerializableWriter {

	public SerializableWriter() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		FileOutputStream fos = new FileOutputStream("/Users/kangmac/_Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);		
		ClassA classA = new ClassA();
		classA.field1 = 1;
		classA.field2.field1 = 2;
		classA.field3 = 3;
		classA.field4 = 4;
		oos.writeObject(classA);
		oos.flush();	oos.close(); fos.close();	
	}
}
