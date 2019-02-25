package org.tain.fep.example.server;

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
	private StreamServerProperty serverProperty;

	private InetSocketAddress isa = null;

	private InputStream is = null;
	private OutputStream os = null;

	public CommunicationThread(Socket socket, StreamServerProperty serverProperty) throws Exception {
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

		if (flag) {
			//
			try {
				if (flag) {
					// recv
					byte[] bytLength = recv(6);
					String strLength = new String(bytLength, "EUC-KR");
					int len = Integer.parseInt(strLength) - 6;
					byte[] bytBuffer = recv(len);
					String strBuffer = new String(bytBuffer, "EUC-KR");
					
					if (flag) System.out.printf(">>>>> Server RECV : [%s] [%s]%n", strLength, strBuffer);
				}

				if (flag) {
					// send
					String message = "000040SH00000008515012019012960017900000";
					String strLength = message.substring(0, 6);
					String strBuffer = message.substring(6);
					byte[] bytLength = strLength.getBytes("EUC-KR");
					byte[] bytBuffer = strBuffer.getBytes("EUC-KR");
					send(bytLength);
					send(bytBuffer);
					this.os.flush();
					
					if (flag) System.out.printf(">>>>> Server SEND : [%s] [%s]%n", strLength, strBuffer);
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

		}

		if (flag) {
			System.out.println(">>>>> dis-connection : " + this.isa);
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
