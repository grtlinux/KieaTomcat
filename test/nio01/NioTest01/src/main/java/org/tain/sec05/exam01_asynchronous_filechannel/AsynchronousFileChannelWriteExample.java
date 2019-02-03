package org.tain.sec05.exam01_asynchronous_filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("AsynchronousFileChannelWriteExample")
public class AsynchronousFileChannelWriteExample {

	public AsynchronousFileChannelWriteExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		//스레드를 생
		ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors() 
		);
		
		for(int i=0; i<10; i++) {
			Path path = Paths.get("/Users/kangmac/_file" + i + ".txt");
			Files.createDirectories(path.getParent());
			
			//비동기 파일 채널 생
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
				path, 
				EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE),
				executorService
			);  
			
			//파일에 저장할 데이터를 ByteBuffer에 저장
			Charset charset = Charset.defaultCharset();
			ByteBuffer byteBuffer = charset.encode("안녕하세요.");
			
			//첨부 객체 생
			class Attachment {
				Path path;
				AsynchronousFileChannel fileChannel;
			}
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			
			//CompletionHandler 객체 생		
			CompletionHandler<Integer, Attachment> completionHandler = 
				new CompletionHandler<Integer, Attachment>() {
				@Override
				public void completed(Integer result, Attachment attachment) {
					System.out.println(attachment.path.getFileName() + " : " + result + " bytes written : " + Thread.currentThread().getName());
					try { attachment.fileChannel.close(); } catch (IOException e) {}
				}
				@Override
				public void failed(Throwable exc, Attachment attachment) {
					exc.printStackTrace();
					try { attachment.fileChannel.close(); } catch (IOException e) {}
				}
			};
			
			fileChannel.write(byteBuffer, 0, attachment, completionHandler);
		}
		
		//스레드를 종료
		executorService.shutdown();
	}
}
