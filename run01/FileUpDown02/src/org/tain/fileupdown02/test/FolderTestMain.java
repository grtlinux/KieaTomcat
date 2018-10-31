package org.tain.fileupdown02.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;
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
	
	/*
	 * URL: https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
	 */
	private static void test01(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		if (!flag) {
			// file information
			final File file = new File("/hanwha/_TEMP/spring3.zip");
			System.out.printf("FILE: %s%n", file.getName());
		}
		
		if (!flag) {
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
		
		if (!flag) {
			// using the below function listFilesForFolder
			final File folder = new File("/hanwha/_TEMP");
			listFilesForFolder(folder);
		}
		
		if (!flag) {
			// this code is available from java 8
			try (Stream<Path> paths = Files.walk(Paths.get("/hanwha/_TEMP"))) {
				paths.filter(Files::isRegularFile).forEach(System.out::println);
			}
		}
		
		if (!flag) {
			// this code is available from java 8
			try (Stream<Path> filePathStream = Files.walk(Paths.get("/hanwha/_TEMP"))) {
				filePathStream.forEach(filePath -> {
					if (Files.isRegularFile(filePath)) {
						System.out.println(">>>>> " + filePath);
					}
				});
			}
		}
		
		if (!flag) {
			Files.walkFileTree(Paths.get("/hanwha/_TEMP"), new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					System.out.println(">>>>> " + file);
					return FileVisitResult.CONTINUE;
				}
			});
		}
		
		if (flag) {
			File folder = new File("/hanwha/_TEMP");
			File[] files = folder.listFiles(new FileFilter() {
				public boolean accept(File file) {
					return file.isFile();
				}
			});
			
			for (File file : files) {
				System.out.println(">>>> " + file.getCanonicalPath());
			}
		}
		
		if (!flag) {
			// no understand
			DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
				public boolean accept(Path file) throws IOException {
					try {
						return Files.isRegularFile(file);
					} catch (Exception e) {
						System.out.println(e);
						return false;
					}
				}
			};
		}
		
		if (!flag) {
			List<File> filesInFolder = Files.walk(Paths.get("/hanwha/_TEMP"))
					.filter(Files::isRegularFile)
					.map(Path::toFile)
					.collect(Collectors.toList());
			
			for (File file : filesInFolder) {
				// \hanwha\_TEMP\_runjar\20181028\RunJar01.jar
				//System.out.println(">>>>> " + file.getPath());
				
				// RunJar01.jar
				//System.out.println(">>>>> " + file.getName());
				
				// C:\hanwha\_TEMP\_runjar\20181028\RunJar01.jar
				//System.out.println(">>>>> " + file.getAbsolutePath());
				
				// C:\hanwha\_TEMP\_runjar\20181028\RunJar01.jar
				//System.out.println(">>>>> " + file.getCanonicalPath());
				
				// \hanwha\_TEMP\_runjar\20181028
				System.out.println(">>>>> " + file.getParent());
			}
			
			System.out.println(">>>>> filesInFolder.size() = " + filesInFolder.size());
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
