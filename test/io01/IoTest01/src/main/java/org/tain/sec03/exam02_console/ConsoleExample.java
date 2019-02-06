package org.tain.sec03.exam02_console;

import java.io.Console;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "ConsoleExample")
public class ConsoleExample {

	private static final boolean flag = true;
	
	public ConsoleExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (flag) return;
		
		Console console = System.console();

		System.out.print("아이디: ");
		String id = console.readLine();

		System.out.print("패스워드: ");
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);

		System.out.println("---------------------");
		System.out.println(id);
		System.out.println(strPassword);
	}
}
