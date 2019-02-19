package org.tain.fep.stream2json;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;
import org.tain.utils.HttpClientResponse;

@Component(value = "fep.stream2json.StreamToJson")
public class StreamToJsonTest {

	private static final boolean flag = true;
	
	@Bean(value = "fep.stream2json.StreamToJson.test01")
	public void test01() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		String stream = null;
		
		if (flag) {
			// get stream
			stream = HttpClientResponse.getInstance().getReqStram(0);
			if (flag) System.out.println(">>>>> STREAM: " + stream);
		}
		
		if (flag) {
			// get field info
		}
	}
}
