package org.tain.sec04.exam01_field;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("UsingThisExample")
public class UsingThisExample {

	public UsingThisExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		UsingThis usingThis = new UsingThis();
		UsingThis.Inner inner = usingThis.new Inner();
		
		inner.method();
	}
}
