package org.tain.fep.stream.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.tain.fep.http.FepHttp;
import org.tain.fep.json.ReqInfo;
import org.tain.fep.json.ResInfo;
import org.tain.fep.property.Property;
import org.tain.utils.BeanUtils;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

public class CommunicationThread extends Thread {

	private static final boolean flag = true;

	private Socket socket = null;
	private Integer cnt = 0;
	private Property property;

	private InetSocketAddress isa = null;

	private InputStream is = null;
	private OutputStream os = null;

	public CommunicationThread(Socket socket, Integer cnt) throws Exception {
		this.socket = socket;
		this.cnt = cnt;
		//this.property = property;
		this.property = (Property) BeanUtils.getBean("fep.property.Property");
		if (!flag) System.out.println(">>>>> " + this.property);

		this.isa = (InetSocketAddress) this.socket.getRemoteSocketAddress();

		this.is = this.socket.getInputStream();
		this.os = this.socket.getOutputStream();
	}

	@Override
	public void run() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> connection : " + this.isa);
		}

		if (flag) {
			//
			try {
				String reqStream = null;
				ReqInfo reqInfo = null;
				String reqJson = null;
				
				String resJson = null;
				ResInfo resInfo = null;
				String resStream = null;
				
				if (flag) {
					// recv
					byte[] bytLength = recv(6);
					String strLength = new String(bytLength, "EUC-KR");
					int len = Integer.parseInt(strLength) - 6;
					byte[] bytBuffer = recv(len);
					String strBuffer = new String(bytBuffer, "EUC-KR");
					reqStream = strLength + strBuffer;
					
					if (flag) System.out.printf(">>>>> Server RECV : [%s] [%s]%n", strLength, strBuffer);
					if (flag) System.out.printf(">>>>> Server RECV : reqStream = [%s]%n", reqStream);
				}

				if (flag) {
					// REQ: stream -> json
					reqInfo = new ReqInfo(reqStream);
					reqJson = reqInfo.getReqDataJson();
					if (flag) System.out.println(">>>>> Server REQ json = " + reqJson);
				}
				
				if (flag) {
					// TODO KANG-20190228: FepHttp
					resJson = FepHttp.getInstance().post("http://localhost:8080/server/save", reqJson);
					if (flag) System.out.println(">>>>> Server RES json = " + resJson);
				}
				
				if (flag) {
					// RES: json -> stream
					resInfo = new ResInfo(reqInfo.getReqDataNode());
					resStream = resInfo.getResStream();
					if (!flag) System.out.println(">>>>> Server resStream = " + resStream);
				}
				
				if (flag) {
					// send
					// resStream = "000040SH00000008515012019012960017900000";
					String strLength = resStream.substring(0, 6);
					String strBuffer = resStream.substring(6);
					byte[] bytLength = strLength.getBytes("EUC-KR");
					byte[] bytBuffer = strBuffer.getBytes("EUC-KR");
					send(bytLength);
					send(bytBuffer);
					this.os.flush();
					
					if (flag) System.out.printf(">>>>> Server SEND : resStream = [%s]%n", resStream);
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
			System.out.printf(">>>>> [cnt=%5d] dis-connection : ", this.cnt, this.isa);
		}
	}

	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

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
