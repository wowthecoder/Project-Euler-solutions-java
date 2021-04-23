//Problem 43: d2d3d4=406 is divisible by 2
//d3d4d5=063 is divisible by 3
//d4d5d6=635 is divisible by 5
//d5d6d7=357 is divisible by 7
//d6d7d8=572 is divisible by 11
//d7d8d9=728 is divisible by 13
//d8d9d10=289 is divisible by 17
//Find the sum of all 0 to 9 pandigital numbers with this property.

class SubstringDivisibility {
	public static void main(String[] args) {
		String numStr = "1023456789";
		int[] divisors = {2, 3, 5, 7, 11, 13, 17};
		long sum = 0;
		while (true) {
			int[] substrings = new int[7];
			boolean gotProperty = true;
			for (int i = 1; i <= 7; i++) {//i is the starting index 
				substrings[i-1] = Integer.parseInt(numStr.substring(i, i+3));
				if (substrings[i-1] % divisors[i-1] != 0) {
					gotProperty = false;
					break;
				}
			}
			if (gotProperty) {
				System.out.println("Number found: " + numStr);
				sum += Long.parseLong(numStr);
			}
			String nextStr = generateNextPermutation(numStr);
			if (numStr.equals(nextStr))
				break;
			numStr = nextStr;
		}
		System.out.println("Sum: " + sum);
	}
	
	static String generateNextPermutation(String s) {
		char[] characters = s.toCharArray();
		int k = -1; 
		int l = -1;
		for (int j = characters.length-2; j >= 0; j--) {
			if (Character.getNumericValue(characters[j]) < Character.getNumericValue(characters[j+1])) {
				k = j;
				break;
			}
		}
		if (k == -1) //The given string is already the last permutation(largest value)
			return s;
		for (int m = characters.length-1; m > k; m--) {
			if (Character.getNumericValue(characters[m]) > Character.getNumericValue(characters[k])) {
				l = m;
				break;
			}
		}
		char temp = characters[k];
		characters[k] = characters[l];
		characters[l] = temp;
		//reverse the sequence from position k+1 onwards, reverse only until midpoint
		for (int n = k+1; n < (k+1 + (characters.length-(k+1))/2); n++) {
			char tmp = characters[n];
			characters[n] = characters[characters.length-n+k];
			characters[characters.length-n+k] = tmp;
		}
		return new String(characters);
	}
}
