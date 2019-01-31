package org.tain.generic7;

import org.springframework.stereotype.Component;

@Component
public class ChildProductAndStorageExample {

	public ChildProductAndStorageExample() {
		ChildProduct<Tv, String, String> product = new ChildProduct<>();
		product.setKind(new Tv());
		product.setModel("SmartTV");
		product.setCompany("Samsung");
		
		Storage<Tv> storage = new StorageImpl<Tv>(123);
		storage.add(new Tv(), 0);
		Tv tv = storage.get(0);
		
		System.out.println(">>>>> tv = " + tv);
	}
}
