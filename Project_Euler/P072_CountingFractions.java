//Problem 72: How many elements would be contained in the 
//set of reduced proper fractions for d <= 1,000,000?
import java.util.ArrayList;

class CountingFractions {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long count = 0;
		boolean[] primes = new boolean[1000000];
		for (int i = 1; i < primes.length; i++) {
			primes[i] = true;
		}
		//Store all the values of multiples of primes * 1 - 1/p
		long[] values = new long[1000000];
		for (int j = 0; j < values.length; j++) {
			values[j] = j+1;
		}
		for (int p = 2; 2*p <= 1000000; p++) {
			if (primes[p-1] == true) {
				for (int q = 2*p; q <= 1000000; q += p) {
					primes[q-1] = false;
					long numer = p - 1;
					long denom = p;
					values[q-1] = (values[q-1] * numer) / denom;
				}
			}
		}
		//Use Euler's Totient Function to calculate all the numerators that are relatively prime to the denominator
		for (int d = 2; d <= 1000000; d++) {
			count += eulerTotientwithSieve(d, primes, values);
		}
		System.out.println(count);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
	
	static long eulerTotientwithSieve(int n, boolean[] primes, long[] values) {
		//All primes have (n-1) numbers that are relatively prime to them
		if (primes[n-1] == true) 
			return n-1;
		return values[n-1];
	}
}
