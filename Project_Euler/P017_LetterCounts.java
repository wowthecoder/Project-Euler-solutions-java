//Problem 17: If all the numbers from 1 to 1000 (one thousand) inclusive 
//were written out in words, how many letters would be used?

class LetterCounts {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += numLetterCount(i);
		}
		System.out.println(sum);
	}
	
	static int numLetterCount(int n) {
		int count = 0;
		String[] lessThan10 = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] lessThan20 = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String[] numStr = Integer.toString(n).split("");
		for (int j = 0; j < numStr.length; j++) {
			int digit = Integer.parseInt(numStr[j]);
			int digitValue = digit * (int)Math.pow(10, numStr.length-j-1);
			if (digit == 0)
				continue;
			if (digitValue % 1000 == 0) {
				count += lessThan10[digit-1].length();
				count += 8;//"thousand"
				if (Integer.parseInt(numStr[j+1]) == 0 && (Integer.parseInt(numStr[j+2]) != 0 || Integer.parseInt(numStr[j+3]) != 0)) {//1056, 1070, 1002 need to add the word "and"
					count += 3;//"and"
				}
			}
			else if (digitValue % 100 == 0) {
				count += lessThan10[digit-1].length();
				count += 7;//"hundred"
				if (Integer.parseInt(numStr[j+1]) != 0 || Integer.parseInt(numStr[j+2]) != 0) //150, 107 need to add "and"
					count += 3;//"and"
			}
			else if (digitValue % 10 == 0) {
				int lastDigit = Integer.parseInt(numStr[j+1]);
				if (digit == 1 && lastDigit != 0) {// 11,12,13,...
					count += lessThan20[lastDigit-1].length();
					break;
				}
				else 
					count += tens[digit-1].length();
			}
			else
				count += lessThan10[digit-1].length();
		}
		return count;
	}
}
