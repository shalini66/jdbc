package com.tyss.jdbc.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		List<String> li = new ArrayList<String>();
		li.add("aaa");
		li.add("bbb");
		li.add("ccc");
		li.add("ddd");
		
		Iterator<String> itr = li.iterator();
		while(itr.hasNext()) {
			String s = itr.next();
			System.out.println(s);
		}
	}
}
