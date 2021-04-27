//Problem 46: What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
public class GoldbachOtherConjecture {

	public static void main(String[] args) {
		int[] twiceASquare = new int[1000];
		for (int i = 0; i < twiceASquare.length; i++) {
			twiceASquare[i] = 2 * (i+1)*(i+1);
		}
		boolean[] primes = new boolean[2000000];
		for (int j = 1; j < primes.length; j++) {
			primes[j] = true;
		}
		for (int p = 2; p*p <= 2000000; p++) {
			if (primes[p-1] == true) {
				for (int q = p*p; q <= 2000000; q += p) {
					primes[q-1] = false;
				}
			}
		}
		//Check every odd number
		for (int k = 7; k < 10000; k += 2) {
			if (primes[k-1] == true)
				continue;
			boolean gotEquation = false;
			for (int num : twiceASquare) {
				if (num > k)
					break;
				if (primes[k - num - 1] == true)
					gotEquation = true;
			}
			if (!gotEquation) {
				System.out.println(k);
				break;
			}
		}
	}
}
