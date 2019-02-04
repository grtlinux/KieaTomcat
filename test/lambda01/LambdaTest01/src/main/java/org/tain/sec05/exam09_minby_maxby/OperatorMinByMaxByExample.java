package org.tain.sec05.exam09_minby_maxby;

import java.util.function.BinaryOperator;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "OperatorMinByMaxByExample")
public class OperatorMinByMaxByExample {

	public OperatorMinByMaxByExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		BinaryOperator<Fruit> binaryOperator;
		Fruit fruit;
		
		binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
		fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
		System.out.println(fruit.getName());
		
		binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
		fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
		System.out.println(fruit.getName());
	}
}
