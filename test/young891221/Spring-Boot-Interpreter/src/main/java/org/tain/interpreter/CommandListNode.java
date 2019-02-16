package org.tain.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.tain.utils.ClassUtil;

public class CommandListNode extends Node {

	private List<Node> list = new ArrayList<>();
	
	@Override
	public void parse(Context context) throws ParseException {
		if (!flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		while (true) {
			if (context.getCurrentToken() == null) {
				throw new ParseException("Missing 'end'");
			} else if (context.getCurrentToken().equals("end")) {
				context.skipToken("end");
				break;
			} else {
				Node commandNode = new CommandNode();
				commandNode.parse(context);
				this.list.add(commandNode);
			}
		}
	}
	
	public String toString() {
		return "" + list;
	}
}
