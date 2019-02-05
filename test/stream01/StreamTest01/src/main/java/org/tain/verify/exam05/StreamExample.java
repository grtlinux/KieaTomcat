package org.tain.verify.exam05;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam05.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
	}
}
