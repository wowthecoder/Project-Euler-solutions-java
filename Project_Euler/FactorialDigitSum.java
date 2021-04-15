//Problem: Find the sum of digits of 100!
import java.util.*;
import java.math.BigInteger;

class FactorialDigitSum {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int n = Integer.parseInt(args[0]);//new Scanner(System.in).nextInt();
		BigInteger product = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		String[] str = product.toString().split("");
		int sumOfDigits = 0;
		for (String s : str) {
			int digit = Integer.parseInt(s);
			sumOfDigits += digit;
		}
		System.out.println(sumOfDigits);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + "ms");
	}
}