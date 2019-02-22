package org.tain.example.svr02;

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
					String strLen = new String(recv(6));
					int len = Integer.parseInt(strLen);
					if (flag) System.out.println(">>>>> Server RECV : " + strLen);
					if (flag) System.out.println(">>>>> Server RECV : " + new String(recv(len), "UTF-8"));
				}

				Sleep.run(2000);

				if (flag) {
					// write
					String message = "Hello Client, My name is Server...^^";
					byte[] bytBuffer = message.getBytes("UTF-8");
					byte[] lenBuffer = String.format("%06d", bytBuffer.length).getBytes();
					if (flag) System.out.println(">>>>> Server SEND lenBuffer = " + send(lenBuffer));
					if (flag) System.out.println(">>>>> Server SEND bytBuffer = " + send(bytBuffer));
					this.os.flush();

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
