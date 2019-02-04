package org.tain.sec05.exam01_runnable;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("RunnableExample")
public class RunnableExample {

	public RunnableExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		method1();
		method2();
	}
	
	private void method1() {
		Runnable runnable = () -> {
			for (int i=0; i < 10; i++) {
				System.out.println("method1 " + i);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
	
	private void method2() {
		Thread thread = new Thread(() -> {
			for (int i=0; i < 10; i++) {
				System.out.println("method2 " + i);
			}
		});
		thread.start();
	}
}
