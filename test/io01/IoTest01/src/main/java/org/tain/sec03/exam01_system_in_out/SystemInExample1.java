package org.tain.sec03.exam01_system_in_out;

import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SystemInExample1")
public class SystemInExample1 {

	private static final boolean flag = true;
	
	public SystemInExample1() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (flag) return;
		
		System.out.println("== 메뉴 ==");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.print("메뉴를 선택하세요: ");

		InputStream is = System.in;
		char inputChar = (char) is.read();
		switch(inputChar) {
			case '1':
				System.out.println("예금 조회를 선택하셨습니다.");
				break;
			case '2':
				System.out.println("예금 출금를 선택하셨습니다.");
				break;
			case '3':
				System.out.println("예금 입금를 선택하셨습니다.");
				break;
			case '4':
				System.out.println("종료 하기를 선택하셨습니다.");
				break;
		}
	}
}
