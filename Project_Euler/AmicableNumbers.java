//Problem 21: Evaluate the sum of all the amicable numbers under 10000.

class AmicableNumbers {
	public static void main(String[] args) {
		int[] sumOfDivisors = new int[10000];
		sumOfDivisors[0] = 0;
		int sum = 0;
		for (int i = 1; i < sumOfDivisors.length; i++) {
			sumOfDivisors[i] = countDivisors(i);
		}
		for (int j = 1; j < sumOfDivisors.length; j++) {
			if (sumOfDivisors[j] >= sumOfDivisors.length)
				continue;
			if (sumOfDivisors[sumOfDivisors[j]] == j && sumOfDivisors[j] != j) {
				System.out.println(j + " amicable to " + sumOfDivisors[j]);
				sum += j;
			}
		}
		System.out.println("Sum = " + sum);
	} 
	
	static int countDivisors(int n) {
		int sumOfFactors = 0;
		for (int k = 1; k <= (int)Math.sqrt(n); k++) {
			if (n % k == 0) {
				sumOfFactors += k;	
				if (k != 1 && (n/k) != k)
					sumOfFactors += (n/k);
			}
		}
		return sumOfFactors;
	}
}