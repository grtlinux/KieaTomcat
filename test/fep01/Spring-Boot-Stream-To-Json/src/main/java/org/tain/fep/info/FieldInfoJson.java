package org.tain.fep.info;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

public class FieldInfoJson {

	private static final boolean flag = true;
	
	private List<String> list;  // TODO KANG-20190218: to property yaml
	
	private Map<String, String> map;
	
	public FieldInfoJson() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	
		if (flag) {
			try {
				String[] arr = new String[] { "MastInfo", "StoreInfo", "Item01Info", "Item23Info" };
				this.list = Arrays.asList(arr);
			} catch (Exception e) {
				e.printStackTrace();
				if (flag) System.exit(0);
			}
		}
		
		if (flag) {
			for (String info : list) {
				String filePath = String.format("templates/json/%s.json", info);
				String content = new ClassPathResourceReader(filePath).getContent();
				if (!flag) System.out.println(">>>>> " + content);
			}
		}
	}
	
	public String get(String key) {
		return this.map.get(key);
	}
}
