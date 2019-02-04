package org.tain.sec04.exam01_field;

public class UsingThis {

	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			// Lambda Expression
			MyFunctionalInterface fi = () -> {
				System.out.println("outterField = " + outterField);
				System.out.println("outterField = " + UsingThis.this.outterField);
				System.out.println();
				
				System.out.println("innerField = " + innerField);
				System.out.println("innerField = " + this.innerField);
				System.out.println();
			};
			fi.method();
		}
	}
}
