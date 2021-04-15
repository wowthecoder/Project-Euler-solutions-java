//Problem: ind the difference between the sum of the squares of the 
//first one hundred natural numbers and the square of the sum.

class SumSquare {
	public static void main(String[] args) {
		long sumOfSqr = 0;
		long allSqr = 0;
		for (int i = 1; i <= 100; i++) {
			sumOfSqr += i;
			allSqr += i*i;
		}
		sumOfSqr *= sumOfSqr;
		System.out.println(sumOfSqr - allSqr);
	}
}
