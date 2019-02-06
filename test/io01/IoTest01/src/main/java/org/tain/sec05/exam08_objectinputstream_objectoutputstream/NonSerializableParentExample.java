package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "NonSerializableParentExample")
public class NonSerializableParentExample {

	public NonSerializableParentExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		FileOutputStream fos = new FileOutputStream("/Users/kangmac/_Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Child child = new Child();
		child.field1 = "홍길동";
		child.field2 = "홍삼원";
		oos.writeObject(child);
		oos.flush();
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("/Users/kangmac/_Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child v = (Child) ois.readObject();
		System.out.println("field1: " + v.field1);
		System.out.println("field2: " + v.field2);
		ois.close();
		fis.close();
	}
}
