package org.tain.sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample1 {

	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i=0; i < 5; i++) {
			toolkit.beep();
			try { Thread.sleep(500); } catch (InterruptedException e) {}
		}

		for (int i=0; i < 5; i++) {
			System.out.println("띵");
			try { Thread.sleep(500); } catch (InterruptedException e) {}
		}
	}
}
