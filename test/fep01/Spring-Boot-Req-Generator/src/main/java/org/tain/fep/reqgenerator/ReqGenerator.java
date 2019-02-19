package org.tain.fep.reqgenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component(value = "fep.reqgenerator.ReqGenerator")
public class ReqGenerator {

	private static final boolean flag = true;
	
	private static final String REQ_STREAM_FILE = "templates/data/Request01(Euckr).dat";
	
	private List<String> list;
	private int index;
	
	public ReqGenerator() {
		if (flag) {
			this.list = new ArrayList<>();
		}
		
		if (flag) {
			BufferedReader bufferedReader = null;
			try {
				Resource resource = new ClassPathResource(REQ_STREAM_FILE);
				bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "EUC-KR"));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if (!flag) System.out.println(">>>>> " + line);
					this.list.add(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
				if (flag) System.exit(0);
			} finally {
				if (bufferedReader != null) try { bufferedReader.close(); } catch (Exception e) {}
			}
		}
		
		if (flag) {
			this.index = 0;
		}
	}
	
	public byte[] getReqStreamLine(){
		
		byte[] byteRet = null;
		
		try {
			byteRet = this.list.get(index).getBytes("EUC-KR");
		} catch (Exception e) {
			return null;
		}
		
		this.index ++;
		
		return byteRet;
	}
	
	public void reset() {
		this.index = 0;
	}
}