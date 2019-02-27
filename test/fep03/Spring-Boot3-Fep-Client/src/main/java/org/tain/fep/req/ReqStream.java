package org.tain.fep.req;

import java.util.List;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.tain.fep.property.Property;
import org.tain.utils.ClassPathResourceReader;
import org.tain.utils.ClassUtil;

@Component(value = "fep.req.ReqStream")
@DependsOn(value = {"fep.property.Property"})
public class ReqStream {

	private static boolean flag = true;

	//@Autowired
	private Property property;

	private List<String> listReq;

	//@Autowired
	public ReqStream(Property property) {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		this.property = property;
		if (!flag) System.out.println(">>>>> ReqStream." + this.property);
	}

	public String get(int index) {
		if (this.listReq == null) {
			setListReq();
			if (this.listReq == null)
				return null;
		}

		return this.listReq.get(index % this.listReq.size());
	}

	private void setListReq() {
		this.listReq = ClassPathResourceReader.getInstance().getList(this.property.getReqData());
		if (!flag) System.out.println(">>>>> " + this.listReq);
	}
}
