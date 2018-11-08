package sample1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext("beans.xml");
	}
}
