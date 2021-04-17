//Problem 32: Find the sum of all products whose multiplicand/multiplier/product identity
//can be written as 1 through 9 pandigital
import java.util.HashSet;

class PandigitalProducts {
	public static void main(String[] args) {
		long sum = 0;
		//use hashset to avoid duplicate answers
		HashSet<Long> products = new HashSet<>();
 		for (long a = 1; a <= 10000; a++) {
			for (long b = 1; b <= 10000; b++) {
				if (a > 1000 && b > 10)
					break;
				long product = a * b;
				int totalDigits = numOfDigits(a) + numOfDigits(b) + numOfDigits(product);
				if (totalDigits != 9)
					continue;
				if (isPandigital(a, b, product)) {
					products.add(product);
					System.out.println(a + " x " + b + " = " + product);
				}
			}
		}
		for (Long results : products) {
			sum += results;
		}
		System.out.println(sum);
	}
	
	static int numOfDigits(long n) {
		int digitCount = 0;
		while (n > 0) {
			digitCount++;
			n /= 10;
		}
		return digitCount;
	}
	
	static boolean isPandigital(long x, long y, long z) {
		HashSet<Integer> digits = new HashSet<>();
		while (x > 0) {
			int digit = (int)(x % 10);
			if (digit != 0)
				digits.add(digit);
			x /= 10;
		}
		while (y > 0) {
			int digit = (int)(y % 10);
			if (digit != 0)
				digits.add(digit);
			y /= 10;
		}
		while (z > 0) {
			int digit = (int)(z % 10);
			if (digit != 0)
				digits.add(digit);
			z /= 10;
		}
		if (digits.size() != 9)
			return false;
		return true;
	}
}
