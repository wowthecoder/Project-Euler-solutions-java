//Problem 49: The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: 
//(i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
//There is one other 4-digit increasing sequence.
//What 12-digit number do you form by concatenating the three terms in this sequence?
import java.util.ArrayList;
import java.util.Arrays;

public class PrimePermutations {

	public static void main(String[] args) {
		//use segmented sieve to generate primes between 1000 and 10000
		boolean[] primeFactors = new boolean[(int)Math.sqrt(10000)];
		//N is upper bound(10000), M is lower bound(1000)
		ArrayList<Integer> primesBelowSqrtN = new ArrayList<>();
		for (int i = 1; i < primeFactors.length; i++) {
			primeFactors[i] = true;
		}
		for (int p = 2; p*p <= primeFactors.length; p++) {
			if (primeFactors[p-1] == true) {
				for (int q = p*p; q <= primeFactors.length; q += p) {
					primeFactors[q-1] = false;
				}
			}
		}
		for (int j = 0; j < primeFactors.length; j++) {
			if (primeFactors[j] == true) 
				primesBelowSqrtN.add(j+1);
		}
		boolean[] primeArr = new boolean[9000];//primes from 1000 to 9999(4-digit numbers)
		for (int k = 0; k < primeArr.length; k++) {
			primeArr[k] = true;
		}
		for (int prime : primesBelowSqrtN) {
			int startingPoint = (int)(1000 / prime) * prime;
			if (startingPoint < 1000)
				startingPoint += prime;
			while (true) {
				if (startingPoint >= 10000)
					break;
				primeArr[startingPoint - 1000] = false;
				startingPoint += prime;
			}
		}
		//Save the list of primes
		ArrayList<Integer> requiredPrimes = new ArrayList<>();
		for (int m = 0; m < primeArr.length; m++) {
			if (primeArr[m] == true) 
				requiredPrimes.add(m+1000);
		}
		//Now loop through each prime and check for the permutations
		for (int r = 0; r < requiredPrimes.size(); r++) {
			ArrayList<Integer> sameDigitPrimes = new ArrayList<>();
			sameDigitPrimes.add(requiredPrimes.get(r));
			for (int s = r+1; s < requiredPrimes.size(); s++) {
				if (containSameDigits(requiredPrimes.get(r), requiredPrimes.get(s))) {
					sameDigitPrimes.add(requiredPrimes.get(s));
				}				
			}
			if (sameDigitPrimes.size() < 3)
				continue;
			//Since the primes need to be in arithmetic sequence(constant difference between terms)
			//for each prime saved, loop through the other primes(2nd term) and get the diff, then 2nd term + diff = 3rd term
			//Then check if the 3rd term exists in the list. If it exists, then we found the answer
			for (int t = 0; t < sameDigitPrimes.size(); t++) {
				int firstTerm = sameDigitPrimes.get(t);
				if (firstTerm == 1487) //we don't want this answer, we need another one
					break;
				for (int u = t+1; u < sameDigitPrimes.size(); u++) {
					int secondTerm = sameDigitPrimes.get(u);
					int diff = secondTerm - firstTerm;
					int thirdTerm = secondTerm + diff;
					if (sameDigitPrimes.contains(thirdTerm)) {
						System.out.println("The concatenated number is: " + firstTerm + "" + secondTerm + "" + thirdTerm);
						return;
					}
				}
			}
		}
	}

	static boolean containSameDigits(int a, int b) {
		int[] digitA = new int[4];
		int[] digitB = new int[4];
		int index = 0; 
		while (a > 0) {
			digitA[index] = a % 10;
			a /= 10;
			index++;
		}
		index = 0;
		while (b > 0) {
			digitB[index] = b % 10;
			b /= 10;
			index++;
		}
		Arrays.sort(digitA);
		Arrays.sort(digitB);
		return Arrays.equals(digitA, digitB);
	}
}
