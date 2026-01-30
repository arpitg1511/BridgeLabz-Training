package com.arpit.junit_practice;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {
	StringUtils strUtil = new StringUtils();
	
	@Test
	void reverseTest() {
		assertEquals("tipra", strUtil.reverseString("arpit"));
	}
	
	@Test
	void isPalindromeTest() {
		assertEquals(true, strUtil.isPalindrome("nitin"));
	}
	
	@Test
	void toUpperCaseTest() {
		assertEquals("ARPIT", strUtil.toUppercase("arpit"));
	}
}
