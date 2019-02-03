package org.tain.sec06.exam01_serversocketchannel_socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerExample {

	public ServerExample() throws Exception {

		ServerSocketChannel serverSocketChannel = null;
		
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);
			serverSocketChannel.bind(new InetSocketAddress(5001));
			
			while (true) {
				System.out.println("listening...");
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress inetSocketAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println("accepted..." + inetSocketAddress.getHostName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (serverSocketChannel.isOpen()) {
				try {
					serverSocketChannel.close();
				} catch (IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ServerExample();
	}
}
