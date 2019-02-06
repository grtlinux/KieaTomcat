package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child extends Parent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String field2;
	
	private void writeObject(ObjectOutputStream out) throws Exception {
		out.writeUTF(field1);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws Exception {
		field1 = in.readUTF();
		in.defaultReadObject();
	}
}
