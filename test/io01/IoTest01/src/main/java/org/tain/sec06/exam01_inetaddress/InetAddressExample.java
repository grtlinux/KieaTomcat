package org.tain.sec06.exam01_inetaddress;

import java.net.InetAddress;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "InetAddressExample")
public class InetAddressExample {

	public InetAddressExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내컴퓨터 IP주소: " + local.getHostAddress());
		
		InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress remote : iaArr) {
			System.out.println("www.naver.com IP주소: " + remote.getHostAddress());
		}
	}
}
