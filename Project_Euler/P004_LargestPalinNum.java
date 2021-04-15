//Problem: Find the largest palindrome made from the product of two 3-digit numbers.
import java.util.*;

class LargestPalinNum {
	public static void main(String[] args) {
		int largest = 0;
		int smallestInner = 100;
		int i = 999, j = 999;
		while (i-- > 100) {
			j = 999;
			while (j-- > smallestInner) {
				int product = i*j;
				System.out.println(i + " x " + j + " = " + product);
				//check if it's palindrome by using string reverse
				String s = Integer.toString(product);
				StringBuilder sReverse = new StringBuilder(s);
				sReverse.reverse();
				if (s.equals(sReverse.toString()) && product > largest) {
					largest = product;
					smallestInner = j;
					break;
				}	
			}			
		}
		System.out.println(largest);
	}
}
