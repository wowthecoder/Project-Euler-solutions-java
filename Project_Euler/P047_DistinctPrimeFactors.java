//Problem 47: Find the first four consecutive integers to have four distinct 
//prime factors each. What is the first of these numbers?

class DistinctPrimeFactors {
	public static void main(String[] args) {
		int[] numOfFactors = new int[4];
		long[] fourNumbers = {10, 11, 12, 13};
		for (int j = 0; j < 4; j++) {
			numOfFactors[j] = numOfPrimeFactors(fourNumbers[j]);
		}
		while (true) {
			numOfFactors[3]= numOfPrimeFactors(fourNumbers[3]);
			boolean isAll4 = true;
			for (int k : numOfFactors) {
				if (k != 4)
					isAll4 = false;
			}
			if (isAll4) {
				System.out.println(fourNumbers[0]);
				break;
			}
			//if not all 4, then move the last 3 elements 1 step forward(since it's already calculated)
			fourNumbers[0] = fourNumbers[1];
			fourNumbers[1] = fourNumbers[2];
			fourNumbers[2] = fourNumbers[3];
			fourNumbers[3] = fourNumbers[2] + 1;
			numOfFactors[0] = numOfFactors[1];
			numOfFactors[1] = numOfFactors[2];
			numOfFactors[2] = numOfFactors[3];
			numOfFactors[3] = 0;
		}
	}
	
	static int numOfPrimeFactors(long n) {
		int count = 0;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				count++;
			while (n % i == 0) {
				n /= i;
			}
		}
		if (n > 2)
			count++;
		return count;
	}
}
