//Problem 41: What is the largest n-digit pandigital prime that exists?
import java.util.ArrayList;

public class PandigitalPrime {

	public static void main(String[] args) {
		//The sum of digits can be used to determine whether the number is divisible by 3 or not
		//If the sum of digits is divisible by 3, then the number itself is also divisible by 3
		//For example, all 1 to 9 pandigital numbers have the sum of digits 1+2+3+4+5+6+7+8+9 = 45, which is divisible by 3
		//That means all 1 to 9 pandigital numbers is divisible by 3 and therefore are not primes
		//After calculating the sum of digits for all 1 to n pandigital numbers, I find that only when n=7 or n=4 then only pandigital prime exists
		//So we just check for all 1 to 7 pandigital primes(because 4 digit is too small)
		
		//Use segmented sieve to generate all 7-digit primes first(lower bound: 1000000, upper bound: 10000000)
		long startTime = System.nanoTime();
		boolean[] primes = new boolean[9000000];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		//Generate all primes below square root of upper bound
		boolean[] primesBelowSqrtN = new boolean[(int)Math.sqrt(10000000)];
		for (int j = 1; j < primesBelowSqrtN.length; j++) {
			primesBelowSqrtN[j] = true;
		}
		for (int p = 2; p*p <= primesBelowSqrtN.length; p++) {
			if (primesBelowSqrtN[p-1] == true) {
				for (int q = p*p; q <= primesBelowSqrtN.length; q += p) {
					primesBelowSqrtN[q-1] = false;
				}
			}
		}
		ArrayList<Integer> primeFactors = new ArrayList<>();
		for (int s = 0; s < primesBelowSqrtN.length; s++) {
			if (primesBelowSqrtN[s] == true) 
				primeFactors.add(s+1);
		}
		for (int primeFactor : primeFactors) {
			int startingPoint = (int)(1000000 / primeFactor) * primeFactor;
			if (startingPoint < 1000000)
				startingPoint += primeFactor;
			for (int t = startingPoint; t < (primes.length+1000000); t += primeFactor) {
				primes[t-1000000] = false;
			}
		}
		String currentPermutation = "7654321";
		while (true) {
			int num = Integer.parseInt(currentPermutation);
			if (primes[num-1000000] == true) {
				System.out.println("Hooray you found the answer: " + num);
				System.out.println("Time to take a break and listen to some Rick Astley songs!");
				break;
			}
			String nextPermutation = nextSmallerPermutation(currentPermutation);
			if (nextPermutation.equals(currentPermutation)) {
				System.out.println("No pandigital prime found! Aduhai");
				break;
			}
			currentPermutation = nextPermutation;
		}	
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
	
	static String nextSmallerPermutation(String numStr) {
		char[] characters = numStr.toCharArray();
		int k = -1, l = 0;
		for (int a = characters.length-2; a >= 0; a--) {
			int thisDigit = Character.getNumericValue(characters[a]);
			int nextDigit = Character.getNumericValue(characters[a+1]);
			if (thisDigit > nextDigit) {
				k = a;
				break;
			}
		}
		if (k == -1)
			return numStr;
		for (int b = characters.length-1; b > k; b--) {
			int thisDigit = Character.getNumericValue(characters[b]);
			int kDigit = Character.getNumericValue(characters[k]);
			if (thisDigit < kDigit) {
				l = b;
				break;
			}
		}
		char temp = characters[k];
		characters[k] = characters[l];
		characters[l] = temp;
		//reverse everything from k onwards
		int midPoint = (characters.length-k) / 2 + (k+1);
		for (int m = k+1; m < midPoint; m++) {
			char tmp = characters[m];
			characters[m] = characters[characters.length-(m-k)];
			characters[characters.length-(m-k)] = tmp;
		}
		return new String(characters);
	}
}
