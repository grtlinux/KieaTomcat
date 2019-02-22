package org.tain.fep.generator;

import java.util.List;

import org.tain.utils.ClassPathResourceReader;

public class ReqStreamGenerator {

	private static final boolean flag = true;
	
	private static final String REQ_STREAM_FILE = "templates/data/ReqStream(Euckr).dat";
	
	private List<String> list;
	
	private ReqStreamGenerator() {

		this.list = new ClassPathResourceReader(REQ_STREAM_FILE).getList();

		if (flag) {
			for (String line : this.list) {
				System.out.println(">>>>> " + line);
			}
		}
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
	
	public int size() {
		return this.list.size();
	}
	
	///////////////////////////////////////////////////////////
	
	private static ReqStreamGenerator instance = null;
	
	public synchronized static ReqStreamGenerator getInstance() {
		if (instance == null) {
			instance = new ReqStreamGenerator();
		}
		
		return instance;
	}
}
