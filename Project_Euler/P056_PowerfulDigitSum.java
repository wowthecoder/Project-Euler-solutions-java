//Problem 56: Considering natural numbers of the form, a^b, where a, b < 100,
//what is the maximum digital sum?
import java.math.BigInteger;

class PowerfulDigitSum {
	public static void main(String[] args) {
		long maxDigitSum = 0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				BigInteger num = BigInteger.valueOf(a).pow(b);
				long digitSum = sumOfDigits(num);
				if (digitSum > maxDigitSum) 
					maxDigitSum = digitSum;
			}
		}
		System.out.println(maxDigitSum);
	}
	
	static long sumOfDigits(BigInteger n) {
		long sum = 0;
		String[] numStr = n.toString().split("");
		for (String s : numStr) {
			int digit = Integer.parseInt(s);
			sum += digit;
		}
		return sum;
	}
}
