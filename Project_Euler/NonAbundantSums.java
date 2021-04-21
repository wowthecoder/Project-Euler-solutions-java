//Problem 23: Find the sum of all the positive integers 
//which cannot be written as the sum of two abundant numbers.
import java.util.ArrayList;
import java.util.HashSet;
class NonAbundantSums {
	public static void main(String[] args) {
		//find sum of all numbers below 28123(given in question),
		//then minus all numbers that can be written as the sum of 2 abundant numbers.
		long sum = 28123*28124/2;
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		for (int i = 2; i <= 28123; i++) {
			if (isAbundant(i))
				abundant.add(i);
		}
		HashSet<Integer> listedSums = new HashSet<>();
		for (int j = 0; j < abundant.size(); j++) {
			for (int k = j; k < abundant.size(); k++) {
				int currentSum = abundant.get(j) + abundant.get(k);
				if (currentSum > 28123)
					break;
				if (!listedSums.contains(currentSum))
					sum -= currentSum;
				listedSums.add(currentSum);
			}
		}
		System.out.println(sum);
	}
	
	static boolean isAbundant(int n) {
		//Reference: https://mathschallenge.net/library/number/sum_of_divisors
		//Break the number down into prime factors first;
		int N = n;
		if (isPrime(n))
			return false;
		//The index is the prime, the element at that index is the power
		int[] primeFactorPowers = new int[n+1];
		for (int r = 2; r <= (int)Math.sqrt(n); r++) {
			while (n % r == 0) {
				primeFactorPowers[r]++;
				n /= r;
			}
		}
		if (n > 2) 
			primeFactorPowers[n]++;
		int sumOfFactors = 1;
		for (int p = 0; p < primeFactorPowers.length; p++) {
			//sum of factors of a power of prime(p^a) = [p^(a+1) - 1]/(p-1);
			if (primeFactorPowers[p] != 0)
				sumOfFactors *= ((int)Math.pow(p, primeFactorPowers[p]+1) - 1) / (p-1);
		}
		sumOfFactors -= N;
		if (sumOfFactors > N)
			return true;
		return false;
	}
	
	static boolean isPrime(int x) {
		for (int m = 2; m <= (int)Math.sqrt(x); m++) {
			if (x % m == 0)
				return false;
		}
		return true;
	}
}