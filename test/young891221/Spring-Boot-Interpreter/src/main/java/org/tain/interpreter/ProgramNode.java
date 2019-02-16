package org.tain.interpreter;

import org.tain.utils.ClassUtil;

public class ProgramNode extends Node {

	private Node commandListNode;

	@Override
	public void parse(Context context) throws ParseException {
		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		context.skipToken("program");
		this.commandListNode = new CommandListNode();
		this.commandListNode.parse(context);
	}

	public String toString() {
		return "[program " + this.commandListNode + "]";
	}
}
