//Problem 58: If one complete new layer is wrapped around the spiral above, 
//a square spiral with side length 9 will be formed. If this process is continued, 
//what is the side length of the square spiral 
//for which the ratio of primes along both diagonals first falls below 10%?

class SpiralPrimes {
	public static void main(String[] args) {
		//build a list of primes first
		boolean[] primes = new boolean[100000000];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		primes[0] = false; // 1 is not prime
		for (int p = 2; p*p <= 100000000; p++) {
			if (primes[p-1] == true) {
				for (int q = p*p; q <= 100000000; q += p) {
					primes[q-1] = false;
				}
			}
		}
		//now count the number of diagonal numbers and primes
		int primeCount = 0;
		int diagonalCount = 1;
		int sideLength = 3;
		int setCount = 1;
		int constantDiff = 2;
		int i = 3;
		while (true) {
			diagonalCount++;
			if (i > 100000000) {
				if (isPrime(i))
					primeCount++;
			}
			else if (primes[i-1] == true)
				primeCount++;
			double primeRatio = (double)primeCount / (double)diagonalCount;
			if (setCount == 4) {
				constantDiff += 2;
				setCount = 0;
			}
			if (primeRatio < 0.1d) {
				System.out.println(sideLength);
				break;
			}
			System.out.println(sideLength + " : " + primeRatio);
			setCount++;
			if ((int)Math.sqrt(i) == Math.sqrt(i))
				sideLength += 2;
			i += constantDiff;
		}
	}
	
	static boolean isPrime(int n) {
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}