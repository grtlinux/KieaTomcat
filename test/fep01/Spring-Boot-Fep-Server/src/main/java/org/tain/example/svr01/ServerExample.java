package org.tain.example.svr01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.tain.utils.ClassUtil;

//@Component(value = "example.svr01.ServerExample")
public class ServerExample {

	private static final boolean flag = true;
	
	@Autowired
	private ServerProperty serverProperty;
	
	@Bean(value = "example.svr01.ServerExample.test01")
	public void test01() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + serverProperty);
		}

		if (flag) {
			// 2019.02.13
			ServerSocket serverSocket = null;
			
			try {
				serverSocket = new ServerSocket();
				serverSocket.bind(new InetSocketAddress("localhost", this.serverProperty.getListenPort()));
				while (true) {
					System.out.println(">>>>> waiting for client connection...");
					Socket socket = serverSocket.accept();
					new CommunicationThread(socket, this.serverProperty).start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (!serverSocket.isClosed()) {
					try { serverSocket.close(); } catch (IOException e) {}
				}
			}
		}
		
		System.exit(0);
	}
}
