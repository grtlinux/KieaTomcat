package org.tain.sec03.exam03_scanner;

import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ScannerExample")
public class ScannerExample {

	private static final boolean flag = true;

	public ScannerExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (flag) return;

		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열 입력> ");
		String inputString = scanner.nextLine();
		System.out.println(inputString);
		System.out.println();

		System.out.print("정수 입력> ");
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();

		System.out.print("실수 입력> ");
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);

		scanner.close();
	}
}
