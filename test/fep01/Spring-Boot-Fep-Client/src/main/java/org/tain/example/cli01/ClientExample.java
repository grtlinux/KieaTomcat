package org.tain.example.cli01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.tain.utils.ClassUtil;
import org.tain.utils.Sleep;

//@Component(value = "example.cli01.ClientExample")
public class ClientExample {

	private static final boolean flag = true;
	
	@Autowired
	private ClientProperty clientProperty;
	
	@Bean(value = "example.cli01.ClientExample.test01")
	public void test01() {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + this.clientProperty);
		}

		if (flag) {
			Socket socket = null;
			InputStream is = null;
			OutputStream os = null;
			
			try {
				socket = new Socket();
				System.out.println(">>>>> request connection...");
				socket.connect(new InetSocketAddress(this.clientProperty.getHost(), this.clientProperty.getPort()));
				System.out.println(">>>>> connection success");
				
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				Sleep.run(1000);
				
				if (flag) {
					// write
					String message = "Hello Sever";
					byte[] bytes = message.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					
					System.out.println(">>>>> SEND: " + message);
				}

				if (flag) {
					// read
					byte[] bytes = new byte[1024];
					int nread = 0;
					
					nread = is.read(bytes);
					
					String message = new String(bytes, 0, nread, "UTF-8");
					
					System.out.println(">>>>> RECV: " + message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (!socket.isClosed()) {
					try { socket.close(); } catch (IOException e) {}
				}
				if (is != null) {
					try { is.close(); } catch (IOException e) {}
				}
				if (os != null) {
					try { os.close(); } catch (IOException e) {}
				}
			}
		}
		
		if (flag) {
			System.out.println(">>>>> dis-connection..");
			System.exit(0);
		}
	}
}
