package org.tain.sec05.exam03_supplier;

import java.util.function.IntSupplier;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("SupplierExample")
public class SupplierExample {

	public SupplierExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수: " + num);
	}
}
