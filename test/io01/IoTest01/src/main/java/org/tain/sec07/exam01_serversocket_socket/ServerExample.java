package org.tain.sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.tain.utils.ClassUtil;

public class ServerExample {

	public static void main(String[] args) throws Exception {

		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while (true) {
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept();
				InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함] " + inetSocketAddress.getHostName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!serverSocket.isClosed()) {
				try {
					serverSocket.close();
				} catch (IOException e) {}
			}
		}
	}
}
