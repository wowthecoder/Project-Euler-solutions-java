//Problem 57: Sqroot 2 as fraction. In the first one-thousand expansions, 
//how many fractions contain a numerator with more digits than the denominator?
import java.math.BigInteger;

class SqrootConvergent {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int count = 0;
		//first fraction is 1 + 1/2 = 3/2
		BigInteger numer = new BigInteger("3");
		BigInteger denom = new BigInteger("2");
		for (int i = 2; i <= 1000; i++) {
			//add 1
			numer = numer.add(denom);
			//invert the fraction
			BigInteger temp = numer;
			numer = denom;
			denom = temp;
			//add 1 again
			numer = numer.add(denom);
			String numerStr = numer.toString();
			String denomStr = denom.toString();
			if (numerStr.length() > denomStr.length()) {
				System.out.println(numerStr + " / " + denomStr);
				count++;
			}
		}
		System.out.println(count);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
}
