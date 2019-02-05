package org.tain.verify.exam07;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam07.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
	}
}
