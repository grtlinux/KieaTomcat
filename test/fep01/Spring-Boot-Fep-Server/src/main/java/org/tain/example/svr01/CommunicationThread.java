package org.tain.example.svr01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

public class CommunicationThread extends Thread {

	private static final boolean flag = true;
	
	private Socket socket = null;
	private ServerProperty serverProperty;
	
	private InetSocketAddress isa = null;
	
	private InputStream is = null;
	private OutputStream os = null;
	
	public CommunicationThread(Socket socket, ServerProperty serverProperty) throws Exception {
		this.socket = socket;
		this.serverProperty = serverProperty;
		
		this.isa = (InetSocketAddress) this.socket.getRemoteSocketAddress();

		this.is = this.socket.getInputStream();
		this.os = this.socket.getOutputStream();
	}
	
	@Override
	public void run() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + this.serverProperty);
			System.out.println(">>>>> connection : " + this.isa);
		}

		if (!flag) {
			//
			try {
				if (flag) {
					// read
					byte[] bytes = new byte[1024];
					int nread = 0;
					
					nread = is.read(bytes);
					
					String message = new String(bytes, 0, nread, "UTF-8");
					
					System.out.println(">>>>> RECV: " + message);
				}
				
				Sleep.run(2000);
				
				if (flag) {
					// write
					String message = "Hello Client";
					byte[] bytes = message.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					
					System.out.println(">>>>> SEND: " + message);
				}
				
				Sleep.run(1000);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (!this.socket.isClosed()) {
					try { this.socket.close(); } catch (IOException e) {}
				}
				if (this.is != null) {
					try { this.is.close(); } catch (IOException e) {}
				}
				if (this.os != null) {
					try { this.os.close(); } catch (IOException e) {}
				}
			}
		}
		
		if (flag) {
			
		}
		
		if (flag) {
			System.out.println(">>>>> dis-connection : " + this.isa);
		}
	}
}
