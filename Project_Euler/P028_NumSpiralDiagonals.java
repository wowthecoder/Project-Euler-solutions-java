//Problem 28: What is the sum of the numbers 
//on the diagonals in a 1001 by 1001 spiral formed in the same way?

class NumSpiralDiagonals {
	public static void main(String[] args) {
		//notice that the diagonals start with 1, then 3,5,7,9 with constant difference 2
		//then +4 to another set of 4 numbers 13,17,21,25 with constant difference 4
		//then +6 to another set of 4 numbers 31,37,43,49
		//Also notice that the largest number is the size of the array squared
		//E.g. 5x5 grid max number is 5^2 = 25
		int maxNum = 1001*1001;
		long sum = 1;
		int constantDiff = 2;
		int setCount = 0;
		for (int i = 3; i <= maxNum; i += constantDiff) {
			sum += i;
			setCount++;
			if (setCount == 4) {
				setCount = 0;
				constantDiff += 2;
			}
		}
		System.out.println(sum);
	}
}
