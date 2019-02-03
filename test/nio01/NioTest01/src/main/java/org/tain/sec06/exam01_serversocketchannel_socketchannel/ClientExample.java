package org.tain.sec06.exam01_serversocketchannel_socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientExample {

	public ClientExample() throws Exception {
		
		SocketChannel socketChannel = null;
		
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(true);
			System.out.println("request connection...");
			socketChannel.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("success of connection...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socketChannel.isOpen()) {
				try {
					socketChannel.close();
				} catch (IOException e) {}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ClientExample();
	}
}
