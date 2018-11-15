package org.tain.fileupdown02.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.tain.fileupdown02.utils.ClassUtils;

public class FileSortTestMain {

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
			File folder = new File("/_KANG/[ 도구 ]/[ Url ]");
			if (!folder.isDirectory()) {
				return;
			}

			File[] fileArr = folder.listFiles();
			for (File file : fileArr) {
				System.out.println(">>> " + file.getName());
			}

			Arrays.sort(fileArr, new Comparator<File>() {
				@Override
				public int compare(File file1, File file2) {
					return file2.getName().compareTo(file1.getName());
				}
			});

			for (File file : fileArr) {
				System.out.println(">>> " + file.getName());
			}

			Arrays.sort(fileArr, new Comparator<File>() {
				@Override
				public int compare(File file1, File file2) {
					if (file1.lastModified() < file2.lastModified())
						return 1;
					else
						return -1;
				}
			});

			for (File file : fileArr) {
				System.out.println(">>> " + String.valueOf(file.lastModified()) + ": " + file.getName());
			}
		}

		if (flag) {
			List<Path> lstPath = Files.list(Paths.get("/_KANG/[ 도구 ]/[ Url ]"))
					.filter(p -> Files.exists(p))
					.map(s -> s.getFileName())
					.sorted()
					.collect(Collectors.toList());
			lstPath.forEach(System.out::println);
		}
	}
}
