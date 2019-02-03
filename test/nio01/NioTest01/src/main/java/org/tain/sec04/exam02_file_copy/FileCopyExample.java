package org.tain.sec04.exam02_file_copy;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
public class FileCopyExample {

	public FileCopyExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path from = Paths.get("src/main/java/org/tain/sec04/exam02_file_copy/house1.jpg");
		Path to = Paths.get("src/main/java/org/tain/sec04/exam02_file_copy/house2.jpg");
		
		FileChannel fileChannel_from = FileChannel.open(
			from, StandardOpenOption.READ);
		
		FileChannel fileChannel_to = FileChannel.open(
			to, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount;
		while(true) {
			buffer.clear();
			byteCount = fileChannel_from.read(buffer);
			if(byteCount == -1) break;
			buffer.flip();
			fileChannel_to.write(buffer);
		}
		
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("파일 복사 성공");
	}
}
