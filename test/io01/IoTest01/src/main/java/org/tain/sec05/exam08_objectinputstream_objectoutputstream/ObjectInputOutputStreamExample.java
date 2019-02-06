package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ObjectInputOutputStreamExample")
public class ObjectInputOutputStreamExample {

	public ObjectInputOutputStreamExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		FileOutputStream fos = new FileOutputStream("/Users/kangmac/_Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(new Integer(10));
		oos.writeObject(new Double(3.14));
		oos.writeObject(new int[] { 1, 2, 3 });
		oos.writeObject(new String("홍길동"));

		oos.flush();
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("/Users/kangmac/_Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();

		ois.close();
		fis.close();

		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3[0] + "," + obj3[1] + "," + obj3[2]);
		System.out.println(obj4);
	}
}
