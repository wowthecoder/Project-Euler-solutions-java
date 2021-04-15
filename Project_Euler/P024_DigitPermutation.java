//Problem 24: What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
import java.util.*;

class DigitPermutation {
	public static void main(String[] args) {
		String currentStr = "0123456789";
		int n = 1;
		while (true) {
			StringBuilder nextStr = new StringBuilder(currentStr);
			int k = 0;
			int l = 0;
			for (int i = 0; i < 10; i++) {
				if (i != 9 && Character.getNumericValue(currentStr.charAt(i)) < Character.getNumericValue(currentStr.charAt(i+1)))
					k = i;
			}
			for (int j = 0; j < 10; j++) {
				if (Character.getNumericValue(currentStr.charAt(j)) > Character.getNumericValue(currentStr.charAt(k)) && j > l)
					l = j;
			}
			char c = currentStr.charAt(k);
			nextStr.setCharAt(k, currentStr.charAt(l));
			nextStr.setCharAt(l, c);
			String temp = nextStr.substring(k+1);
			StringBuilder temp2 = new StringBuilder(temp);
			temp2.reverse();
			String finalStr = "";
			finalStr += (nextStr.substring(0, k+1) + temp2.toString());
		    currentStr = finalStr;
			n++;
			if (n == 1000000) {
				System.out.println(currentStr);
				break;
			}
		}
	}
}
