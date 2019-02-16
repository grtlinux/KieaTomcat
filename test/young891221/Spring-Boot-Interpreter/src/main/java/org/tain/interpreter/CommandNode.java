package org.tain.interpreter;

import org.tain.utils.ClassUtil;

public class CommandNode extends Node {

	private Node node;
	
	@Override
	public void parse(Context context) throws ParseException {
		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		if (context.getCurrentToken().equals("repeat")) {
			this.node = new RepeatCommandNode();
		} else {
			this.node = new PrimitiveCommandNode();
		}
		
		this.node.parse(context);
	}
	
	public String toString() {
		return node.toString();
	}
}
