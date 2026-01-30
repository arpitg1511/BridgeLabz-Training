package com.arpit.junit_practice;

public class StringUtils {
	
	public String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
	
	public boolean isPalindrome(String str) {
		int low = 0;
		int high = str.length() - 1;
		
		while(low <= high) {
			char a = str.charAt(low);
			char b = str.charAt(high);
			
			if(a != b) return false;
			
			low++;
			high--;
		}
		
		return true;
	}
	
	public String toUppercase(String str) {
		return str.toUpperCase();
	}
}
