package org.tain.sec03.exam01_system_in_out;

import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SystemInExample2")
public class SystemInExample2 {

	private static final boolean flag = true;
	
	public SystemInExample2() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (flag) return;
		
		InputStream is = System.in;
		
		byte[] datas = new byte[100];
		
		System.out.print("이름: ");
		int nameBytes = is.read(datas);
		String name = new String(datas, 0, nameBytes-2);
		
		System.out.print("하고 싶은말: ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("입력한 이름: " + name);	
		System.out.println("입력한 하고 싶은말: " + comment);	
	}
}
