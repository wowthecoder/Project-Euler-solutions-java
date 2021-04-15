//Problem: By considering the terms in the Fibonacci sequence whose 
//values do not exceed four million, 
//find the sum of the even-valued terms.

class EvenFibonacci {
	static long[][] matrix = new long[2][2];
	public static void main(String[] args) {
		long sum = 0; 
		int index = 1;
		while (true) {
			long currentTerm = fibonacci(index);
			if (currentTerm >= 4000000)
				break;
			if (currentTerm % 2 == 0) 
				sum += currentTerm;
			System.out.println(currentTerm + ":" + index);
			index++;
		}
		System.out.println("hey " + sum);
	}
	
	static long fibonacci(int n) {
		if (n == 1)
			return 1;
		matrix[0][0] = 1;
		matrix[0][1] = 1;
		matrix[1][0] = 1;
		matrix[1][1] = 0;
		power(matrix, n-1);
		return matrix[0][0];
	}
	//binary exponentiation
	static void power(long[][] matrix, int n) {
		long[][] clone = {{1,1}, {1,0}};
		if (n == 0 || n == 1)
			return;
		power(matrix, n/2);
		multiply(matrix, matrix);
		if (n % 2 != 0)
			multiply(matrix, clone);
	}
	
	static void multiply(long[][] first, long[][] second) {
		long x = first[0][0]*second[0][0] + first[0][1]*second[1][0]; 
		long y = first[0][0]*second[0][1] + first[0][1]*second[1][1]; 
		long z = first[1][0]*second[0][0] + first[1][1]*second[1][0]; 
		long w = first[1][0]*second[0][1] + first[1][1]*second[1][1]; 
		matrix[0][0] = x;
		matrix[0][1] = y;
		matrix[1][0] = z;
		matrix[1][1] = w;
	}
}