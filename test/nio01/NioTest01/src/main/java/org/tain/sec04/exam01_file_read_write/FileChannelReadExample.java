package org.tain.sec04.exam01_file_read_write;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component
@DependsOn(value = {"FileChannelWriteExample"})
public class FileChannelReadExample {

	public FileChannelReadExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path path = Paths.get("/Users/kangmac/_file.txt");

		FileChannel fileChannel = FileChannel.open(
			path, StandardOpenOption.READ);
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		
		Charset charset = Charset.defaultCharset();
		String data = "";
		int byteCount;
		
		while(true) {
			byteCount = fileChannel.read(byteBuffer);
			if(byteCount == -1) break;
			byteBuffer.flip();
			data += charset.decode(byteBuffer).toString();
			byteBuffer.clear();
		}
		
		fileChannel.close();
		
		System.out.println("/Users/kangmac/_file.txt : " + data);
	}
}
