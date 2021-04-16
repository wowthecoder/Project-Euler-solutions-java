//Problem 25: What is the index of the first term 
//in the Fibonacci sequence to contain 1000 digits?
import java.math.BigInteger;
import java.util.*;

class LargeFibonacci {
	public static void main(String[] args) {
		BigInteger[][] matrix = new BigInteger[2][2];
		reset(matrix);
		List<BigInteger> list = new ArrayList<>();
		int term = 100;
		while (true) {
			power(matrix, term-1);
			String numStr = matrix[0][0].toString();
			if (numStr.length() == 1000)
				break;
			term++;
			reset(matrix);
		}
		System.out.println(term);
	}
	
	static void reset(BigInteger[][] matrix) {
		matrix[0][0] = new BigInteger("1");
		matrix[0][1] = new BigInteger("1");
		matrix[1][0] = new BigInteger("1");
		matrix[1][1] = new BigInteger("0");
	}
	
	static void power(BigInteger[][] matrix, int pow) {
		BigInteger[][] clone = new BigInteger[2][2];
		clone[0][0] = new BigInteger("1");
		clone[0][1] = new BigInteger("1");
		clone[1][0] = new BigInteger("1");
		clone[1][1] = new BigInteger("0");
		if (pow == 0 || pow == 1) 
			return;
		power(matrix, pow/2);
		multiply(matrix, matrix);
		if (pow % 2 == 1) 
			multiply(matrix, clone);
	}
	
	static void multiply(BigInteger[][] first, BigInteger[][] second) {
		BigInteger x = (first[0][0].multiply(second[0][0])).add(first[0][1].multiply(second[1][0]));
		BigInteger y = (first[0][0].multiply(second[1][0])).add(first[0][1].multiply(second[1][1]));
		BigInteger z = (first[1][0].multiply(second[0][0])).add(first[1][1].multiply(second[1][0]));
		BigInteger w = (first[1][0].multiply(second[1][0])).add(first[1][1].multiply(second[1][1]));
		first[0][0] = x;
		first[0][1] = y;
		first[1][0] = z;
		first[1][1] = w;
	}
}
