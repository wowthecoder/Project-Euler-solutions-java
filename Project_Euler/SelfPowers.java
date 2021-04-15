//Problem 48: Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
import java.math.BigInteger;

class SelfPowers {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		BigInteger sum = BigInteger.ZERO;
		for (int n = 1; n <= 1000; n++) {
			BigInteger num = BigInteger.valueOf(n);
			sum = sum.add(num.pow(n)); 
		}
		System.out.println(sum.mod(BigInteger.valueOf(10000000000L)));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
}