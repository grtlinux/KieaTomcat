package org.tain.fep.stream.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.tain.fep.http.FepHttp;
import org.tain.fep.info.ReqDataInfo;
import org.tain.fep.info.ReqFieldInfo;
import org.tain.fep.info.ResDataInfo;
import org.tain.fep.info.ResFieldInfo;
import org.tain.fep.json.ReqJson;
import org.tain.fep.json.ResJson;
import org.tain.fep.property.Property;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

@Component(value = "fep.stream.client.StreamClient")
@DependsOn(value = {"fep.req.ReqStream"})
public class StreamClient {

	private static final boolean flag = true;
	
	private Socket socket;
	private InetSocketAddress isa;
	private InputStream is;
	private OutputStream os;
	
	@Autowired
	private Property property;
	
	public StreamClient() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}

	public String runner(String reqJson) {
		
		if (!flag) return "SUCCESS";
		
		String reqStream = reqJson;
		String resStream = null;
		String resJson = null;
		
		if (flag) {
			try {
				this.socket = new Socket();
				if (flag) System.out.println(">>>>> request connection...");
				this.socket.connect(new InetSocketAddress(this.property.getStreamHost(), this.property.getStreamPort()));
				this.isa = (InetSocketAddress) this.socket.getRemoteSocketAddress();
				if (flag) System.out.println(">>>>> connection success : " + this.isa);
				
				this.is = this.socket.getInputStream();
				this.os = this.socket.getOutputStream();
				
				if (!flag) {
					// REQ: json -> stream
					ReqDataInfo reqDataInfo = ReqJson.getInstance().getReqDataInfo(reqJson);
					ReqFieldInfo reqFieldInfo = ReqJson.getInstance().getReqFieldInfo(reqDataInfo);
					reqStream = ReqJson.getInstance().getStream(reqFieldInfo);
					if (flag) System.out.println(">>>>> reqStream = " + reqStream);
				}
				
				if (flag) {
					// send
					String strLength = reqStream.substring(0, 6);
					String strBuffer = reqStream.substring(6);
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
					resStream = strLength + strBuffer;
					
					if (flag) System.out.printf(">>>>> Client RECV : [%s] [%s]%n", strLength, strBuffer);
				}
				
				if (!flag) {
					// RES: stream -> json
					ResFieldInfo resFieldInfo = ResJson.getInstance().getResFieldInfo(resStream);
					ResDataInfo resDataInfo = ResJson.getInstance().getResDataInfo(resFieldInfo);
					resJson = FepHttp.getInstance().getJson(resDataInfo);
					if (flag) System.out.println(">>>>> resJson = " + resJson);
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
			resJson = resStream;
			if (flag) System.out.println(">>>>> dis-connection..");
			if (!flag) System.exit(0);
		}
		
		return resJson;
	}
	
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	
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
