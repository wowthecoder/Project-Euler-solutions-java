//Problem: Find the sum of all the primes below 2 million

class SumOfPrimes {
	public static void main(String[] args) {
		boolean[] primes = new boolean[2000000];
		for (int i = 0; i < 2000000; i++) {
			primes[i] = true;
		}
		primes[0] = false;
		primes[1] = false;
		for (int p = 2; p*p < 2000000; p++) {
			if (primes[p] == true) {
				for (int j = p*p; j < 2000000; j += p) {
					primes[j] = false;
				}
			}
		}
		long sum = 0;
		for (int k = 0; k < 2000000; k++) {
			if (primes[k] == true)
				sum += k;
		}
		System.out.println(sum);
	}
}