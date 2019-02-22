package org.tain.fep.fieldInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

public class FieldInfo {

	private static final boolean flag = true;

	private List<String> list;
	private Map<String, String> map = new HashMap<>();

	private FieldInfo() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (flag) {
			try {
				String[] arr = new String[] { "MastInfo", "StoreInfo", "Item01Info", "Item23Info", "ResMastInfo" };
				this.list = Arrays.asList(arr);
				if (!flag) System.out.println(">>>>> list: " + this.list);
			} catch (Exception e) {
				e.printStackTrace();
				if (flag) System.exit(0);
			}
		}
		
		if (flag) {
			for (String info : this.list) {
				String filePath = String.format("templates/json/%s.json", info);
				if (flag) System.out.printf(">>>>> Map <- [info=%s] [filePath=%s]%n", info, filePath);

				String content = new ClassPathResourceReader(filePath).getContent();
				this.map.put(info, content);
				
				if (!flag) System.out.printf(">>>>> content=%s%n", info, filePath, content);
			}
		}
	}

	public String get(String key) {
		return this.map.get(key);
	}

	public List<String> getList() {
		return this.list;
	}

	////////////////////////////////////////////////////////////////

	private static FieldInfo instance = null;

	public synchronized static FieldInfo getInstance() {
		
		if (instance == null) {
			instance = new FieldInfo();
		}
		
		return instance;
	}
}
