//Problem 16: What is the sum of the digits of the number 21000?
import java.math.BigInteger;

class PowerDigitSum {
	static BigInteger number = new BigInteger("2");
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		power(Integer.parseInt(args[0]));
		String[] str = number.toString().split("");
		int digitSum = 0;
		for (String s : str) {
			int digit = Integer.parseInt(s);
			digitSum += digit;
		}
		System.out.println(digitSum);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds: " + timeElapsed/1000000 + "ms");
	}
	
	static void power(int pow) {
		if (pow == 0 || pow == 1)
			return;
		power(pow/2);
		number = number.multiply(number);
		if (pow % 2 != 0)
			number = number.multiply(BigInteger.valueOf(2));
	}
}
