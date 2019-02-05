package org.tain.verify.exam06;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam06.StreamExample")
public class StreamExample {

	public StreamExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
	}
}
