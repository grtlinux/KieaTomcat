package org.tain.fep.generator;

import java.util.List;

import org.tain.utils.ClassPathResourceReader;

public class ResStreamGenerator {

	private static final boolean flag = true;
	
	private static final String RES_STREAM_FILE = "templates/data/ResStream(Euckr).dat";
	
	private List<String> list;
	
	private ResStreamGenerator() {

		this.list = new ClassPathResourceReader(RES_STREAM_FILE).getList();

		if (flag) {
			for (String line : this.list) {
				System.out.println(">>>>> " + line);
			}
		}
	}
	
	public String get(int index) {
		String ret;
		
		try {
			ret = this.list.get(index).replace('.', ' ');
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
	
	private static ResStreamGenerator instance = null;
	
	public synchronized static ResStreamGenerator getInstance() {
		if (instance == null) {
			instance = new ResStreamGenerator();
		}
		
		return instance;
	}
}
