package org.tain.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.collections4.IteratorUtils;

public class ConvertUtil {

	private static final boolean flag = true;
	
	private ConvertUtil() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	// apache commons-collections4
	public static List<?> iterToList(Iterator<?> iter) {
		List<?> listRet = IteratorUtils.toList(iter);
		return listRet;
	}

	// java8
	public static List<String> iterToList8(Iterator<String> iter) {
		List<String> listRet = StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED), false)
				.collect(Collectors.<String> toList());
		return listRet;
	}
}
