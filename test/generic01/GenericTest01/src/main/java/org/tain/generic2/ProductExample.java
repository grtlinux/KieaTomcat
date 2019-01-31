package org.tain.generic2;

import org.springframework.stereotype.Component;

@Component
public class ProductExample {

	public ProductExample() {
		Product<Tv, String> product1 = new Product<>();
		product1.setKind(new Tv());
		product1.setModel("스마트 Tv");
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		System.out.println(">>>>> " + tv + ":" + tvModel);
		
		Product<Car, String> product2 = new Product<>();
		product2.setKind(new Car());
		product2.setModel("디젤");
		Car car = product2.getKind();
		String carModel = product2.getModel();
		System.out.println(">>>>> " + car + ":" + carModel);
	}
}
