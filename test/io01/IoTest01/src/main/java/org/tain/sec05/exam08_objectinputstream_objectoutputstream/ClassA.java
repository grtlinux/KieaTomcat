package org.tain.sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;

public class ClassA implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int field1;
	public ClassB field2 = new ClassB();
	public static int field3;
	public transient int field4;
}
