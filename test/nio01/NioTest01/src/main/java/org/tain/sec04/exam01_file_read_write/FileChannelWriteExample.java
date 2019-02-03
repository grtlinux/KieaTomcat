package org.tain.sec04.exam01_file_read_write;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("FileChannelWriteExample")
public class FileChannelWriteExample {

	public FileChannelWriteExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Path path = Paths.get("/Users/kangmac/_file.txt");
		Files.createDirectories(path.getParent());
		
		FileChannel fileChannel = FileChannel.open(
			path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "안녕하세요.";
		Charset charset = Charset.defaultCharset();
		ByteBuffer byteBuffer = charset.encode(data);
		
		int byteCount = fileChannel.write(byteBuffer);
		System.out.println("/Users/kangmac/_file.txt : " + byteCount + " bytes written");
		
		fileChannel.close();
	}
}
