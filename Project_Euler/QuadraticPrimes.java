class QuadraticPrimes
{
	public static void main(String[] args) {
		int maxCount = 0;
		int maxA = 0;
		int maxB = 0;
		//build a list of primes first
		boolean[] primes = new boolean[500000];
		for (int i = 0; i < 500000; i++) {
		    primes[i] = true;
		}
		primes[0]= false;
		for (int p = 2; p*p <= 500000; p++) {
		    if (primes[p-1] == true) {
		        for (int q = p*p; q <= 500000; q += p) {
		            primes[q-1] = false;
		        }
		    }
		}
		for (int a = -999; a < 1000; a++) {
		    for (int b = 2; b <= 1000; b++) {
		        //n^2 + an + b, b must be positive and prime
		        if (primes[b-1] == false)
		            continue;
		        //if a is negative, absolute value of a must be smaller than b
		        if (a < 0 && Math.abs(a) > b)
		            continue;
		        //if a is positive, a+b must be 2 or composite, so that +1 can make primes
		        if (a >= 0 && a + b != 2 && primes[a+b-1] == true)
		            continue;
		        int n = 0;
		        int value = n*n + a*n + b;
		        int count = 0;
		        while (value > 0 && primes[value-1] == true) {
		            count++;
		            n++;
		            value = n*n + a*n + b;
		        }
		        if (count > maxCount) {
		            maxCount = count;
		            System.out.println(maxCount);
		            maxA = a;
		            maxB = b;
		        }
		    }
		}
		System.out.println(maxA + " x " + maxB + " = " + maxA*maxB);
	}
}
