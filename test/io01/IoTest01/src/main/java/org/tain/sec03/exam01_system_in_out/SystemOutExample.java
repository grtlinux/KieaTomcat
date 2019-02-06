package org.tain.sec03.exam01_system_in_out;

import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "SystemOutExample")
public class SystemOutExample {

	public SystemOutExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		OutputStream os = System.out;		
		
		for(byte b=48; b<58; b++) {
			os.write(b);
		}		
		os.write(10);
		
		for(byte b=97; b<123; b++) {
			os.write(b);
		}		
		os.write(10);		

		String hangul = "가나다라마바사아자차카타파하";
		byte[] hangulBytes = hangul.getBytes();
		os.write(hangulBytes);
		
		os.flush();
	}
}
