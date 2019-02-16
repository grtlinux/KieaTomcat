package org.tain.interpreter;

public abstract class Node {

	public static final boolean flag = true;
	
	public abstract void parse(Context context) throws ParseException;
}
