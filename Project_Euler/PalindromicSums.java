//Problem 125: Find the sum of all the numbers less than 108 that are both 
//palindromic and can be written as the sum of consecutive squares.
import java.util.HashSet;

class PalindromicSums {
	public static void main(String[] args) {
		long sum = 0;
		HashSet<Long> foundAnswers = new HashSet<>();
		//Use the formula 1^2 + 2^2 + 3^2 + ... + n^2 = n(n+1)(2n+1)/6
		for (long i = 10000; i >= 2; i--) {
			for (long j = i-2; j >= 0; j--) {
				long sumConsecutiveSqr = (i*(i+1)*(2*i+1))/6 - (j*(j+1)*(2*j+1))/6;
				if (sumConsecutiveSqr >= 100000000)
					break;
				if (isPalindromic(sumConsecutiveSqr) && !foundAnswers.contains(sumConsecutiveSqr)) {
					sum += sumConsecutiveSqr;
					foundAnswers.add(sumConsecutiveSqr);
					System.out.println(i + " and " + j + " produces " + sumConsecutiveSqr);
				}
			}
		}
		System.out.println(sum);
	}
	
	static boolean isPalindromic(long n) {
		String nStr = Long.toString(n);
		StringBuilder nReverse = new StringBuilder(nStr);
		nReverse.reverse();
		String nReverseStr = nReverse.toString();
		if (nStr.equals(nReverseStr))
			return true;
		return false;
	}
}