package org.tain.fep.example.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.tain.utils.ClassUtil;

//@Component(value = "fep.example.server.StreamServer")
public class StreamServer {

	private static final boolean flag = true;
	
	@Autowired
	private StreamServerProperty streamServerProperty;
	
	//@Bean(value = "fep.example.server.StreamServer.runner")
	public void runner() {
		if (flag) {
			if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
			if (flag) System.out.println(">>>>> " + this.streamServerProperty);
		}

		if (flag) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO KANG-20190213: base ServerSocket
					ServerSocket serverSocket = null;
					
					try {
						serverSocket = new ServerSocket();
						serverSocket.bind(new InetSocketAddress("localhost", streamServerProperty.getListenPort()));
						while (true) {
							if (flag) System.out.println(">>>>> waiting for client connection...");
							Socket socket = serverSocket.accept();
							new CommunicationThread(socket, streamServerProperty).start();
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (!serverSocket.isClosed()) {
							try { serverSocket.close(); } catch (IOException e) {}
						}
					}
				}
			}).start();
		}
	}
}
