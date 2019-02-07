package org.tain.sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.tain.utils.ClassUtil;

public class ClientExample {

	public static void main(String[] args) throws Exception {

		System.out.println(">>>>> " + ClassUtil.getClassInfo());

		Socket socket = null;

		try {
			socket = new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {}
			}
		}
	}
}
