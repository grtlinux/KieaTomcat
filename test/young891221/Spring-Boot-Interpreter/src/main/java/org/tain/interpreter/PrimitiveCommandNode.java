package org.tain.interpreter;

import org.tain.utils.ClassUtil;

public class PrimitiveCommandNode extends Node {

	private String name;

	@Override
	public void parse(Context context) throws ParseException {
		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		this.name = context.getCurrentToken();
		context.skipToken(this.name);
		if (!this.name.equals("go")
				&& !this.name.equals("right")
				&& !this.name.equals("left")) {
			throw new ParseException(this.name + " is undefined..");
		}
	}

	public String toString() {
		return this.name;
	}
}
