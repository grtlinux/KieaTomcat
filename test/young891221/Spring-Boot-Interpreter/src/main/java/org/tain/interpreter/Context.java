package org.tain.interpreter;

import java.util.StringTokenizer;

public class Context {

	private StringTokenizer tokenizer;
	private String currentToken;
	
	public Context(String text) {
		this.tokenizer = new StringTokenizer(text);
		nextToken();
	}
	
	public String nextToken() {
		if (this.tokenizer.hasMoreElements()) {
			this.currentToken = this.tokenizer.nextToken();
		} else {
			this.currentToken = null;
		}
		
		return this.currentToken;
	}
	
	public void skipToken(String token) throws ParseException {
		if (!token.equals(this.currentToken)) {
			throw new ParseException("WARNING: " + token + " is excepted, but " + this.currentToken + " is found.");
		}
		nextToken();
	}

	public String getCurrentToken() {
		return this.currentToken;
	}
	
	public int getCurrentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(this.currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("WARNING: " + e);
		}
		
		return number;
	}
}
