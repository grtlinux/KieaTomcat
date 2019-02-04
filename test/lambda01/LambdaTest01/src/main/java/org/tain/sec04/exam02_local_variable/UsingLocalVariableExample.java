package org.tain.sec04.exam02_local_variable;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("UsingLocalVariableExample")
public class UsingLocalVariableExample {

	public UsingLocalVariableExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		UsingLocalVariable usingLocalVariable = new UsingLocalVariable();
		usingLocalVariable.method(20);
	}
}
