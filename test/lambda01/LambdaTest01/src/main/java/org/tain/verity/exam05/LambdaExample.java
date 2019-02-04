package org.tain.verity.exam05;

import java.util.function.IntBinaryOperator;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "exam05.LambdaExample")
public class LambdaExample {

	public LambdaExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		// 최대값 얻기
		int max = maxOrMin((a, b) -> {
			if (a >= b) return a;
			else return b;
		});
		System.out.println("최대값: " + max);
		
		// 최소값 얻기
		int min = maxOrMin((a, b) -> (a <= b) ? a : b);
		System.out.println("최소값: " + min);
	}
	
	private int[] scores = { 10, 50, 3 };
	
	private int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
}
