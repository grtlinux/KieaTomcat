package org.tain.sec05.exam10_identity;

import java.util.function.UnaryOperator;

import org.springframework.stereotype.Component;
import org.tain.utils.ClassUtil;

@Component(value = "IdentityExample")
public class IdentityExample {

	public IdentityExample() {
		System.out.println(">>>>> " + ClassUtil.getClassInfo());
		
		UnaryOperator<Member> operator = UnaryOperator.identity();
		Member member = operator.apply(new Member("홍길동", "Hong"));
		System.out.println("이름: " + member.getName());
		System.out.println("아이디: " + member.getId());
	}
}
