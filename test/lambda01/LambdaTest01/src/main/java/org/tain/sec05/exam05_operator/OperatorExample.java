package org.tain.sec05.exam05_operator;

import java.util.function.IntBinaryOperator;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component("OperatorExample")
public class OperatorExample {

	public OperatorExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		// 최대값 얻기
		int max = maxOrMin(
				(a, b) -> {
					if (a >= b) return a;
					else return b;
				}
		);
		System.out.println("최대값: " + max);
		
		// 최소값 얻기
		int min = maxOrMin(
				(a, b) -> {
					if (a <= b) return a;
					else return b;
				}
		);
		System.out.println("최소값: " + min);
	}
	
	private int[] scores = { 92, 95, 87, 54, 86, 99 };
	
	private int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
}
