//Problem 37: Find the sum of the only eleven primes that are 
//both truncatable from left to right and right to left.

class TruncatablePrime {
	public static void main(String[] args) {
	    long startTime = System.nanoTime();
	    int sum = 0;
		int count = 0; //only 11 truncatable primes
	    //build a list of primes to speed up checking process
	    boolean[] primes = new boolean[100000001];
	    for (int i = 0; i < primes.length; i++) {
		    primes[i] = true;
	    }
		primes[0] = false;
	    for (int p = 2; p*p <= 100000000; p++) {
		    if (primes[p-1] == true) {
			    for (int q = p*p; q <= 100000000; q += p) {
				    primes[q-1] = false;
			    }
		    }
	    }
	    for (int x = 10; x <= 100000000; x++) {
		    if (primes[x-1] == false)
			    continue;
			//If number is prime, truncate from left
			String str = Integer.toString(x);
			boolean isPrime = true;
			for (int j = 1; j < str.length(); j++) {
				String s = str.substring(j, str.length());
				int y = Integer.parseInt(s);
				if (y == 0 || primes[y-1] == false) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				//then truncate from right
				for (int j = str.length()-1; j > 0; j--) {
					String s = str.substring(0, j);
					int y = Integer.parseInt(s);
					if (primes[y-1] == false) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					sum += x;
					count++;
					System.out.println(x);
				}
			}
			if (count == 11)
				break;
	    }
		System.out.println("Sum: " + sum);
	    long endTime = System.nanoTime();
	    long timeElapsed = endTime - startTime;
	    System.out.println(timeElapsed/1000000 + " ms");
	}
}
