package org.tain.sec06.exam02_data_read_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerExample {

	public ServerExample() throws Exception {
		
		ServerSocketChannel serverSocketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);		
			serverSocketChannel.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println( "[연결 기다림]");
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println("[연결 수락] " + isa.getHostName());
				
				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");
				
				byteBuffer = ByteBuffer.allocate(100);
				@SuppressWarnings("unused")
				int byteCount = socketChannel.read(byteBuffer);
				byteBuffer.flip();
				String message = charset.decode(byteBuffer).toString();
				System.out.println("[데이터 받기 성공]: " + message);				
				
				byteBuffer = charset.encode("Hello Client");
				socketChannel.write(byteBuffer);
				System.out.println( "[데이터 보내기 성공]");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(serverSocketChannel.isOpen()) {
				try {
					serverSocketChannel.close();
				} catch (IOException e1) {}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ServerExample();
	}
}
