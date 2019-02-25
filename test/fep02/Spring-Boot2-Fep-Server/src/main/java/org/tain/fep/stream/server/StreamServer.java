package org.tain.fep.stream.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "fep.stream.server.StreamServer")
public class StreamServer {

	private static final boolean flag = true;
	
	@Autowired
	private StreamServerProperty streamServerProperty;
	
	@Bean(value = "fep.stream.server.StreamServer.runner")
	public void runner() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + streamServerProperty);
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
							System.out.println(">>>>> waiting for client connection...");
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
