//Problem 119: The number 512 is interesting because it is equal to the sum of its digits 
//raised to some power: 5 + 1 + 2 = 8, and 8^3 = 512. 
//Another example of a number with this property is 614656 = 28^4.
//You are given that a2 = 512 and a10 = 614656.
//Find a30.
import java.math.BigInteger;
import java.util.*;

class DigitPowerSum {
	public static void main(String[] args) {
		List<BigInteger> terms = new ArrayList<>();
		for (int i = 2; i <= 500; i++) {
			for (int j = 2; j <= 50; j++) {
				BigInteger result = BigInteger.valueOf(i).pow(j);
				int sumOfDigits = sumDigits(result);
				if (sumOfDigits == i) {
					terms.add(result);
				}
			}
		}
		Collections.sort(terms);
		for (int k = 0; k < terms.size(); k++) {
			System.out.println("a" + (k+1) + " : " + terms.get(k));
		}
	}
	
	static int sumDigits(BigInteger n) {
		int sum = 0;
		while (n.compareTo(BigInteger.ZERO) == 1) {
			sum += (n.mod(BigInteger.valueOf(10)).intValue());
			n = n.divide(BigInteger.valueOf(10));
		}
		return sum;
	}
}
