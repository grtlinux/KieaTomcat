package org.tain.sec02.exam01_createthread;

public class BeepPrintExample3 {

	public static void main(String[] args) {
		//how1
		Thread thread = new BeepThread();

		//how2
		/*
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		};
		*/


		thread.start();

		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch(Exception e) {}
		}
	}
}

