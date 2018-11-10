package org.tain.fileupdown02.test;

import java.io.File;
import java.io.FileFilter;

import org.tain.fileupdown02.utils.ClassUtils;

public class FileFilterTestMain {

	private static final boolean flag;

	static {
		flag = true;
	}

	///////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getFileLine());

		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getFileLine());

		if (flag) {
			// File root = new File("/hanwha/_TEMP");
			// File root = new File("\\\\192.168.1.15\\public");  // SUCCESS
			File root = new File("//192.168.1.15/public");       // SUCCESS
			File[] files = root.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.isFile())
						return true;
					return false;
				}
			});
			
			for (File file : files) {
				System.out.println(">>>>> " + file.getName());
			}
		}
	}
}