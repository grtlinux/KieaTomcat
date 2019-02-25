package org.tain.utils;

public class Sleep {

	public static void run(int milli_seconds) {
		try {
			Thread.sleep(milli_seconds);
		} catch (InterruptedException e) {
			//
		}
	}
}
