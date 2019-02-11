package org.tain.bean7;

import org.springframework.stereotype.Component;

@Component(value = "Bean7Test2")
public class Bean7Test2 {

	public void hello() {
		System.out.println(">>>>> Bean7Test2.hello method...");  // OK!!
	}
}
