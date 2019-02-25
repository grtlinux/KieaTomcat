package org.tain.fep.example.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

public class StreamClient {

	private static final boolean flag = true;
	
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	
	@Autowired
	private StreamClientProperty streamClientProperty;
	
	private StreamClient() {}
	
	public void runner(String message) {
		if (flag) {
			if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
			if (flag) System.out.println(">>>>> " + this.streamClientProperty);
		}

		if (!flag) {
			try {
				this.socket = new Socket();
				if (flag) System.out.println(">>>>> request connection...");
				this.socket.connect(new InetSocketAddress(this.streamClientProperty.getHost(), this.streamClientProperty.getPort()));
				if (flag) System.out.println(">>>>> connection success");
				
				this.is = this.socket.getInputStream();
				this.os = this.socket.getOutputStream();
				
				if (flag) {
					// send
					String strLength = message.substring(0, 6);
					String strBuffer = message.substring(6);
					byte[] bytLength = strLength.getBytes("EUC-KR");
					byte[] bytBuffer = strBuffer.getBytes("EUC-KR");
					send(bytLength);
					send(bytBuffer);
					this.os.flush();
					
					if (flag) System.out.printf(">>>>> Client SEND : [%s] [%s]%n", strLength, strBuffer);
				}

				if (flag) {
					// recv
					byte[] bytLength = recv(6);
					String strLength = new String(bytLength, "EUC-KR");
					int len = Integer.parseInt(strLength) - 6;
					byte[] bytBuffer = recv(len);
					String strBuffer = new String(bytBuffer, "EUC-KR");
					
					if (flag) System.out.printf(">>>>> Client RECV : [%s] [%s]%n", strLength, strBuffer);
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
			if (flag) System.out.println(">>>>> dis-connection..");
			if (!flag) System.exit(0);
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
	
	/////////////////////////////////////////////////
	
	private static StreamClient instance = null;
	
	public synchronized static StreamClient getInstance() throws Exception {
		if (instance == null) {
			instance = new StreamClient();
		}
		return instance;
	}
}
