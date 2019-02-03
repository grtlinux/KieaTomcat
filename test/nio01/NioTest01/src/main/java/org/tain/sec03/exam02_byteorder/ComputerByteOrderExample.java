package org.tain.sec03.exam02_byteorder;

import java.nio.ByteOrder;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class ComputerByteOrderExample {

	public ComputerByteOrderExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		System.out.println("운영체제 종류 : "+System.getProperty("os.name"));
		System.out.println("네이티브의 바이트 해석 순­서 : "+ByteOrder.nativeOrder());
	}
}
