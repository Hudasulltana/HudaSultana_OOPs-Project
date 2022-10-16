package com.solveQuestions.lab;
import java.util.*;

public class palindromeCheck {
	
	public static boolean checkPalindrome(String str) {
		int i=0;
		while(i < str.length()/2) {
			if(str.charAt(i) == str.charAt(str.length()-1-i)) {
				i++;
			}
			else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string of your choice.");
		str = sc.next();
		System.out.println(checkPalindrome(str));
	}

}
