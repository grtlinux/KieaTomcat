package org.tain.interpreter;

import org.tain.utils.ClassUtil;

public class RepeatCommandNode extends Node {

	private int number;
	private Node commandListNode;

	@Override
	public void parse(Context context) throws ParseException {
		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		context.skipToken("repeat");
		this.number = context.getCurrentNumber();
		context.nextToken();
		this.commandListNode = new CommandListNode();
		this.commandListNode.parse(context);
	}

	public String toString() {
		return "(repeat " + this.number + " " + this.commandListNode + ")";
	}
}
