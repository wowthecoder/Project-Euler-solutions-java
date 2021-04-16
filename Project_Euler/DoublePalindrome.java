//Problem 36: Find the sum of all numbers, less than one million, 
//which are palindromic in base 10 and base 2.
import java.util.*;

class DoublePalindrome {
	public static void main(String[] args) {
		long sum = 0;
		for (int i = 1; i <= 1000000; i++) {
			String binaryNum = Integer.toBinaryString(i);
			if (isPalindrome(Integer.toString(i)) && isPalindrome(binaryNum)) 
				sum += i;
		}
		System.out.println(sum);
	}
	
	static boolean isPalindrome(String numStr) {
		StringBuilder reverseNum = new StringBuilder(numStr);
		reverseNum.reverse();
		if (numStr.equals(reverseNum.toString()))
			return true;
		return false;
	}
}