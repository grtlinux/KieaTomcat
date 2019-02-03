package org.tain.sec03.exam01_direct_buffer;

import java.nio.ByteBuffer;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class BufferSizeExample {

	@SuppressWarnings("unused")
	public BufferSizeExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		ByteBuffer directBuffer = ByteBuffer.allocateDirect(200 * 1024 * 1024);
		System.out.println("다이렉트 버퍼가 생성되었습니다.");
		
		ByteBuffer nonDirectBuffer = ByteBuffer.allocate(200 * 1024 * 1024);
		System.out.println("넌다이렉트 버퍼가 생성되었습니다.");
	}
}
