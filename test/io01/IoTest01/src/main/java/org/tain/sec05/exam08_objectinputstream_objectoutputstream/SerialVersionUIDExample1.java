package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SerialVersionUIDExample1")
public class SerialVersionUIDExample1 {

	public SerialVersionUIDExample1() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		FileOutputStream fos = new FileOutputStream("/Users/kangmac/_Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ClassC classC = new ClassC();
		classC.field1 = 1;
		oos.writeObject(classC);
		oos.flush();
		oos.close();
		fos.close();
	}
}
