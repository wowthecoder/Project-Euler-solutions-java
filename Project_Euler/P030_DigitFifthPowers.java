//Problem: Find the sum of all the numbers that 
//can be written as the sum of fifth powers of their digits.

class DigitFifthPowers {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int sum = 0;
		for (int x = 10; x < 1000000; x++) {
			int digitSum = 0;
			String[] strArr = Integer.toString(x).split("");
			for (String s : strArr) {
				int digit = Integer.parseInt(s);
				digitSum += (int)Math.pow(digit, 5);
			}
			if (digitSum == x) {
				System.out.println(x);
				sum += x;
			}
		}
		System.out.println("Sum: " + sum);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
}
