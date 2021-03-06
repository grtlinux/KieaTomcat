package org.tain.fep.stream.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.tain.fep.property.Property;
import org.tain.utils.ClassUtil;

@Component(value = "fep.stream.server.StreamServer")
@DependsOn(value = {"fep.property.Property"})
public class StreamServer {

	private static final boolean flag = true;
	
	@Autowired
	private Property property;
	
	public StreamServer() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	@Bean(value = "fep.stream.server.StreamServer.runner")
	public void runner() throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		if (!flag) System.out.println(">>>>> StreamServer.Property -> " + this.property);

		if (flag) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO KANG-20190213: base ServerSocket
					ServerSocket serverSocket = null;
					
					try {
						serverSocket = new ServerSocket();
						serverSocket.bind(new InetSocketAddress(
								StreamServer.this.property.getStreamHost(), 
								StreamServer.this.property.getStreamPort()));
						
						Integer cnt = 0;
						while (true) {
							System.out.printf(">>>>> waiting for client connection...[cnt=%d]%n", ++cnt);
							Socket socket = serverSocket.accept();
							new CommunicationThread(socket, cnt).start();
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
