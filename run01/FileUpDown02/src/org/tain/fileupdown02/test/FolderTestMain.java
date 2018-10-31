package org.tain.fileupdown02.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.tain.fileupdown02.utils.ClassUtils;

public class FolderTestMain {

	private static final boolean flag;
	
	static {
		flag = true;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		if (flag) test01(args);
	}
	
	private static void test01(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		if (flag) {
			// file information
			final File file = new File("/hanwha/_TEMP/spring3.zip");
			System.out.printf("FILE: %s%n", file.getName());
		}
		
		if (flag) {
			// folder information
			final File file = new File("/hanwha/_TEMP");
			System.out.printf("FOLDER: %s%n", file.getName());
		}
		
		if (!flag) {
			String strFolder = "/hanwha/_TEMP";
			final File fileFolder = new File(strFolder);
			for (File file : fileFolder.listFiles()) {
				if (file.isDirectory()) {
					System.out.printf(">>>>> Folder : %s%n", file.getName());
				} else {
					System.out.printf(">>>>> File : %s%n", file.getName());
				}
			}
		}
		
		if (flag) {
			// using the below function listFilesForFolder
			final File folder = new File("/hanwha/_TEMP");
			listFilesForFolder(folder);
		}
		if (!flag) {
			try (Stream<Path> paths = Files.walk(Paths.get("/hanwha/_TEMP"))) {
				paths.filter(Files::isRegularFile).forEach(System.out::println);
			}
		}
	}
	
	private static void listFilesForFolder(final File folder) {
		// recursive function
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				System.out.println(">>> " + fileEntry.getName());
			}
		}
	}
}
