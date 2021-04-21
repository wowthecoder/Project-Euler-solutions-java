//Problem 55: How many Lychrel numbers are there below ten-thousand?
import java.math.BigInteger;
import java.util.ArrayList;

class LychrelNumbers {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int count = 0;
		for (int i = 10; i < 10000; i++) {
			if (isLychrel(i)) 
				count++;
		}
		System.out.println(count);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
	//storing the next reverse number so we don't have to reverse it twice
	static StringBuilder nextReverse = new StringBuilder("");
	static boolean isLychrel(int n) {
		int steps = 0;
		BigInteger bigN = BigInteger.valueOf(n);
		nextReverse = new StringBuilder(bigN.toString());
		nextReverse.reverse();
		while (steps < 50) {
			BigInteger reverseN = new BigInteger(nextReverse.toString());
			bigN = bigN.add(reverseN);
			if (isPalindrome(bigN)) { 
				return false;
			}
			steps++;
		}
		return true;
	}
	
	static boolean isPalindrome(BigInteger x) {
		String xStr = x.toString();
		StringBuilder xReverseStr = new StringBuilder(xStr);
		xReverseStr.reverse();
		nextReverse = xReverseStr;
		if (xStr.equals(xReverseStr.toString()))
			return true;
		return false;
	}
}