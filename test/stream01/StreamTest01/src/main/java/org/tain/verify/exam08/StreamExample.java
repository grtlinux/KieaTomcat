package org.tain.verify.exam08;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam08.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
	}
}
