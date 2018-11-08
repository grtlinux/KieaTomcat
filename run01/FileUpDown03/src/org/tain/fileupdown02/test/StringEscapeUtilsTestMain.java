package org.tain.fileupdown02.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEscapeUtilsTestMain {

	private static final boolean flag = true;
	
	/**
	 * String UnEscape
	 * 
	 * @param src
	 * @return
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}

	/**
	 * String Escape
	 * @param src
	 * @return
	 */
	public static String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		
		return tmp.toString();
	}
	
	/////////////////////////////////////////////////////////////
	
	private static String charSet = "euc-kr";
	
	public static String escape2(String src) throws Exception {
		byte[] bytes = src.getBytes(charSet);
		for (byte byt : bytes) {
			if (byt < 0) {
				System.out.println(String.format("%%%02X", byt));
			} else {
				char ch = (char) byt;
				if (Character.isDigit(ch) || Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
					System.out.println(ch);
				} else {
					System.out.println(String.format("%%%02X", byt));
				}
			}
		}
		
		return null;
	}

	public static String unescape2(String src) {
		for (int i=0; i < src.length(); i++) {
			if (src.charAt(i) == '%') {
				int iCh = Integer.parseInt(src.substring(i+1, i+3), 16);
				i += 3;
				System.out.print(String.format("%c", iCh));
			} else {
				System.out.print(src.charAt(i));
			}
		}
		return null;
	}
	
	///////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		
		if (!flag) test01();
		if (!flag) test02();
		if (!flag) test03();
		if (flag) test04();
	}
	
	private static void test01() {
		if (flag) {
			String str1 = "12345ABCD 강 석";
			String str2 = StringEscapeUtils.escapeHtml(str1);
			String str3 = StringEscapeUtils.unescapeHtml(str2);
			System.out.println(">>>>> " + str1);
			System.out.println(">>>>> " + str2);
			System.out.println(">>>>> " + str3);
			
			//[HD %20 720p] %20 %EB%A0%88 %EB%93%9C %20 %ED%85%8C %EC%9D%BC %EC%8A%A4.smi
		}
	}
	
	private static void test02() {
		if (flag) {
			String str1 = "12345ABCD 강 석";
			String str2 = escape(str1);
			String str3 = unescape(str2);
			System.out.println(">>>>> " + str1);
			System.out.println(">>>>> " + str2);
			System.out.println(">>>>> " + str3);
			
			//[HD %20 720p] %20 %EB%A0%88 %EB%93%9C %20 %ED%85%8C %EC%9D%BC %EC%8A%A4.smi
		}
	}

	private static void test03() throws Exception {
		if (flag) {
			//String str1 = "12345ABCD 강 석";
			// D%20%B0%AD%20%BC%AE

			String str1 = "D 강 석";
			String str2 = escape2(str1);
			String str3 = unescape2("D%20%B0%AD%20%BC%AE");
			System.out.println(">>>>> " + str1);
			System.out.println(">>>>> " + str2);
			System.out.println(">>>>> " + str3);
			
			//[HD %20 720p] %20 %EB%A0%88 %EB%93%9C %20 %ED%85%8C %EC%9D%BC %EC%8A%A4.smi
		}
	}
	
	private static void test04() throws Exception {
		if (flag) {
			String str_kr = "0cm+%EB%98%90%EB%8A%94+%EC%97%86%EC%9D%8C";
			 
			String charset[] = {"euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii", "UTF-8"}; 
			 
			for(int i=0; i<charset.length ; i++){
				System.out.println(charset[i] + " URLEncoder : " + URLEncoder.encode(str_kr, charset[i]));
				System.out.println(charset[i] + " URLDecoder : " + URLDecoder.decode(str_kr, charset[i]));
			}
		}
		
		System.out.println();
		
		if (flag) {
			String str_kr = "http://www.google.co.kr/%EC%86%8C%EC%84%A4.html";
			 
			String charset[] = {"euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii", "UTF-8"}; 
			 
			for(int i=0; i<charset.length ; i++){
				System.out.println(charset[i] + " URLEncoder : " + URLEncoder.encode(str_kr, charset[i]));
				System.out.println(charset[i] + " URLDecoder : " + URLDecoder.decode(str_kr, charset[i]));
			}
		}
		
		System.out.println();
		
		if (flag) {
			String url = "http://www.google.co.kr/";
			String str_kr = "안 녕 하 세 요.html";
			System.out.println("URLEncoder(utf-8): " + URLEncoder.encode(str_kr, "utf-8"));
		}
	}
}
