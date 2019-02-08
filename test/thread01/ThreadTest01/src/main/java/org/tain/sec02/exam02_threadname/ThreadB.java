package org.tain.sec02.exam02_threadname;

public class ThreadB extends Thread {

	@Override
	public void run() {
		for (int i=0; i < 2; i++) {
			System.out.println(this.getName() + "가 출력한 내용");
		}
	}
}
