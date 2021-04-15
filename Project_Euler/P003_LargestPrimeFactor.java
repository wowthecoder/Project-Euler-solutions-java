//Problem: What is the largest prime factor of the number 600851475143 ?

class LargestPrimeFactor {
	public static void main(String[] args) {
		long largest = 0;
		long num = 600851475143L;
		for (long j = 1; j <= (long)Math.sqrt(num); j++) {
			if (num % j == 0) {
				boolean prime = isPrime(j);
				long otherFactor = num/j;
				boolean otherPrime = isPrime(otherFactor);
				if (prime && j > largest)
					largest = j;
				if (otherPrime && otherFactor > largest)
					largest = otherFactor;
			}
		}
		System.out.println(largest);
	}
	
	static boolean isPrime(long n) {
		if (n == 1)
			return false;
		for (long i = 2; i <= (long)Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
