//Problem 50: Which prime, below one-million, 
//can be written as the sum of the most consecutive primes?
import java.util.ArrayList;

class PrimeSums {
	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		boolean[] primes = new boolean[1000000];
		ArrayList<Integer> consecutivePrimeSums = new ArrayList<>();
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		primes[0] = false;//1 is not prime number
		for (int p = 2; p*p <= 1000000; p++) {
			if (primes[p-1] == true) {
				for (int q = p*p; q <= 1000000; q += p) {
					primes[q-1] = false;
				}
			}
		}
		//Store the consecutive prime sums as we iterate through the boolean array
		consecutivePrimeSums.add(0);
		int currentIndex = 1;
		for (int j = 0; j < primes.length; j++) {
			if (primes[j] == true) {
				consecutivePrimeSums.add(consecutivePrimeSums.get(currentIndex-1) + (j+1));
				currentIndex++;
			}
		}
		//Now we use 2 nested for loops to loop through all possible consecutive prime sums
		int maxLength = 0;
		int ans = 0;
		for (int k = consecutivePrimeSums.size()-1; k >= 2; k--) {
			for (int m = k-2; m >= 0; m--) {
				int currentSum = consecutivePrimeSums.get(k) - consecutivePrimeSums.get(m);
				if (currentSum >= 1000000)
					break;
				if (primes[currentSum-1] == true && (k-m) > maxLength) {
					ans = currentSum;
					maxLength = k-m;
				}
			}
		}
		System.out.println(ans);
		/*long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");*/
	}
}
