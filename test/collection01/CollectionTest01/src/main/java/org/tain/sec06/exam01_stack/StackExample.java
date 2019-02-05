package org.tain.sec06.exam01_stack;

import java.util.Stack;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "StackExample")
public class StackExample {

	public StackExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전 : " + coin.getValue() + "원");
		}
		System.out.println();
	}
}
