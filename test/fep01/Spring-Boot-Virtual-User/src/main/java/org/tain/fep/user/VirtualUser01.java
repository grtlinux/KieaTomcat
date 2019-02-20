package org.tain.fep.user;

import org.tain.utils.ClassUtil;

public class VirtualUser01 {

	private static final boolean flag = true;
	
	private VirtualUser01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
	}
	
	
	////////////////////////////////////////////////
	
	private static VirtualUser01 instance;
	
	public synchronized static VirtualUser01 getInstance() {
		if (instance == null) {
			instance = new VirtualUser01();
		}
		
		return instance;
	}
}
