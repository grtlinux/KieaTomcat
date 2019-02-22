package org.tain.example.cli02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

@Component(value = "example.cli01.ClientExample")
public class ClientExample {

	private static final boolean flag = true;
	
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	@Autowired
	private ClientProperty clientProperty;
	
	@Bean(value = "example.cli01.ClientExample.test01")
	public void test01() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + this.clientProperty);
		}

		if (flag) {
			try {
				this.socket = new Socket();
				System.out.println(">>>>> request connection...");
				this.socket.connect(new InetSocketAddress(this.clientProperty.getHost(), this.clientProperty.getPort()));
				System.out.println(">>>>> connection success");
				
				this.is = this.socket.getInputStream();
				this.os = this.socket.getOutputStream();
				
				Sleep.run(1000);
				
				if (flag) {
					// write
					String message = "Hello Sever";
					byte[] bytBuffer = message.getBytes("UTF-8");
					byte[] lenBuffer = String.format("%06d", bytBuffer.length).getBytes();
					if (flag) System.out.println(">>>>> Client SEND lenBuffer = " + send(lenBuffer));
					if (flag) System.out.println(">>>>> Client SEND bytBuffer = " + send(bytBuffer));
					this.os.flush();
					
					System.out.println(">>>>> SEND: " + message);
				}

				if (flag) {
					// read
					String strLen = new String(recv(6));
					int len = Integer.parseInt(strLen);
					if (flag) System.out.println(">>>>> Client RECV : " + strLen);
					if (flag) System.out.println(">>>>> Client RECV : " + new String(recv(len), "UTF-8"));
				}
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
			System.out.println(">>>>> dis-connection..");
			System.exit(0);
		}
	}
	
	private byte[] recv(int length) throws Exception {
		byte[] buffer = new byte[length];
		int nread = 0;
		int offset = 0;
		int sleepCount = 0;
		int maxSleepCount = 20;
		
		while (length > 0) {
			nread = this.is.read(buffer, offset, length);
			if (nread < 0) {
				throw new IOException("ERROR: return value of read is negative..");
			} else if (nread == 0) {
				Sleep.run(100);
				sleepCount ++;
				if (sleepCount > maxSleepCount) {
					throw new IOException("ERROR: looping more than maxSleepCount...");
				}
			}
			
			sleepCount = 0;
			
			offset += nread;
			length -= nread;
		}
		
		return buffer;
	}
	
	private int send(byte[] buffer) throws Exception {
		int length = buffer.length;
		int offset = 0;
		
		this.os.write(buffer, offset, length);
		
		return length;
	}
}
