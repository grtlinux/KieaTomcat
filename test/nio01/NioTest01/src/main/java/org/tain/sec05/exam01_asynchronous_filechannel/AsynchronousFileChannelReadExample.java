package org.tain.sec05.exam01_asynchronous_filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("AsynchronousFileChannelReadExample")
@DependsOn(value = {"AsynchronousFileChannelWriteExample"})
public class AsynchronousFileChannelReadExample {

	public AsynchronousFileChannelReadExample() throws Exception {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		//스레드를 생
		ExecutorService executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors() 
		);

		for(int i=0; i<10; i++) {
			Path path = Paths.get("/Users/kangmac/_file" + i + ".txt");
			
			//비동기 파일 채널 생성
			AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
				path, 
				EnumSet.of(StandardOpenOption.READ),
				executorService
			);
			
			// 파일의 크기와 동일한 capacity를 갖는 버퍼 생
			ByteBuffer byteBuffer = ByteBuffer.allocate((int)fileChannel.size());
			
			//첨부 객체 생성
			class Attachment {
				Path path;
				AsynchronousFileChannel fileChannel;
				ByteBuffer byteBuffer;
			}
			Attachment attachment = new Attachment();
			attachment.path = path;
			attachment.fileChannel = fileChannel;
			attachment.byteBuffer = byteBuffer;
			
			//CompletionHandler 객체 생성
			CompletionHandler<Integer, Attachment> completionHandlernew = 
				new CompletionHandler<Integer, Attachment>() {
				@Override
				public void completed(Integer result, Attachment attachment) {
					attachment.byteBuffer.flip();
					
					Charset charset = Charset.defaultCharset();
					String data = charset.decode(attachment.byteBuffer).toString();
					
					System.out.println(attachment.path.getFileName() + " : " + data + " : " + Thread.currentThread().getName());
					try { fileChannel.close(); } catch (IOException e) {
						//e.printStackTrace();
					}
				}
				@Override
				public void failed(Throwable exc, Attachment attachment) {
					exc.printStackTrace();
					try { fileChannel.close(); } catch (IOException e) {}
				}
			};
			
			//파일 읽기
			fileChannel.read(byteBuffer, 0, attachment, completionHandlernew);
		}
		
		//스레드를 종료
		//Thread.sleep(1000);
		executorService.shutdown();
	}
}
