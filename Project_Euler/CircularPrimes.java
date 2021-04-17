//Problem 35: How many circular primes are there below one million?
import java.util.HashSet;
class CircularPrimes {
	static boolean[] primes = new boolean[1000000];
	public static void main(String[] args) {
		//Sieve of Erathosthenes to generate a list of primes under 1 million
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		primes[0] = false; // 1 is not prime
		for (int p = 2; p*p <= 1000000; p++) {
			if (primes[p-1] == true) {
				for (int q = p*p; q <= 1000000; q += p) {
					primes[q-1] = false;
				}
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 2; i < 1000000; i++) {
			int[] rotations = NumRotations(i);
			if (isCircularPrime(rotations)) {
				for (int x : rotations) {
					set.add(x);
				}
			}
		}
		System.out.println(set.size());
	}
	
	static int[] NumRotations(int n) {
		String numStr = Integer.toString(n);
		int[] rotations = new int[numStr.length()];
		rotations[0] = n;
		int i = 1;
		while (true) {
			String firstDigit = numStr.substring(0, 1);
			String restOfNum = numStr.substring(1, numStr.length());
			numStr = restOfNum + firstDigit;
			if (Integer.parseInt(numStr) == n)
				break;
			rotations[i] = Integer.parseInt(numStr);
			i++;
		}
		//Check if there is 0 in array (e.g. in the case of 11 there is no second element)
		for (int j = 0; j < rotations.length; j++) {
			if (rotations[j] == 0)
				rotations[j] = n;
		}
		return rotations;
	}
	
	static boolean isCircularPrime(int[] rotations) {
		for (int y : rotations) {
			if (primes[y-1] == false)
				return false;
		}
		return true;
	}
}