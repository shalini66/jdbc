package com.tyss.test.main;

import com.tyss.calculator.common.Addition;

public class Add {
	public static void main(String[] args) {
		Addition a = new Addition();
		int res = a.add(3, 3);
		System.out.println("Result = "+res);
	}
}
