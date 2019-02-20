package org.tain.fep.reqgenerator;

import java.util.List;

import org.tain.utils.ClassPathResourceReader;

public class ReqGenerator {

	private static final boolean flag = true;
	
	private static final String REQ_STREAM_FILE = "templates/data/Request01(Euckr).dat";
	
	private List<String> list;
	
	private ReqGenerator() {

		this.list = new ClassPathResourceReader(REQ_STREAM_FILE).getList();

		if (flag) {
			for (String line : this.list) {
				System.out.println(">>>>> " + line);
			}
		}
	}
	
	public int size() {
		return this.list.size();
	}
	
	public String get(int index) {
		String ret;
		
		try {
			ret = this.list.get(index);
		} catch (Exception e) {
			if (!flag) e.printStackTrace();
			ret = null;
		}
		
		return ret;
	}
	
	public List<String> getList() {
		return this.list;
	}
	
	///////////////////////////////////////////////////////////
	
	private static ReqGenerator instance = null;
	
	public synchronized static ReqGenerator getInstance() {
		if (instance == null) {
			instance = new ReqGenerator();
		}
		
		return instance;
	}
}
