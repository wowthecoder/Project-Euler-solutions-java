//Problem 34: 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.

class DigitFactorials {
	public static void main(String[] args) {
		int[] digitValues = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}; //factorial values from 0! to 9!
		//loop until 9999999 which the max sum of the  7 digit factorials is 9! x 7 = 2540160
		//which is smaller than 9999999, meaning that from 9999999 onwards the sum of the 
		//digit values will always be smaller than the number it self
		//999999 = 9! x 6 = 2177280 the max sum is still bigger than the original number
		int sum = 0;
		for (int x = 10; x <= 9999999; x++) {
			int sumOfDigitValues = 0;
			int num = x;
			while (num > 0) {
				int digit = num % 10;
				sumOfDigitValues += digitValues[digit];
				num /= 10;
			}
			if (sumOfDigitValues == x)
				sum += x;
		}
		System.out.println(sum);
	}
}
