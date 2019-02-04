package org.tain.sec06.exam01_method_references;

import java.util.function.IntBinaryOperator;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "MethodReferencesExample")
public class MethodReferencesExample {

	public MethodReferencesExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		IntBinaryOperator operator;
		
		// 정적 메소드 참조 --------------------------------
		operator = (x, y) -> Calculator.staticMethod(x, y);
		System.out.println("결과1: " + operator.applyAsInt(1, 2));
		
		operator = Calculator::staticMethod;
		System.out.println("결과2: " + operator.applyAsInt(3, 4));
		
		// 인스턴스 메소드 참조 -----------------------------
		Calculator inst = new Calculator();
		operator = (x, y) -> inst.instanceMethod(x, y);
		System.out.println("결과3: " + operator.applyAsInt(5, 6));
		
		operator = inst::instanceMethod;
		System.out.println("결과4: " + operator.applyAsInt(7, 8));
	}
}
