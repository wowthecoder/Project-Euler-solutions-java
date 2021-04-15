//Problem 40: An irrational decimal fraction is created by concatenating the positive integers:
//0.123456789101112131415161718192021...
//It can be seen that the 12th digit of the fractional part is 1.
//If dn represents the nth digit of the fractional part, 
//find the value of the following expression.
//d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

class CdudeConstant {
	public static void main(String[] args) {
		int product = digit(1)*digit(10)*digit(100)*digit(1000)*digit(10000)*digit(100000)*digit(1000000);
		System.out.println(product);
	}
	
	static int digit(int n) {
		if (n < 10)
			return n;
		if (n >= 10 && n <= 189) { //two digits 
			int number = ((n - 8) / 2) + 9;
			if (n % 2 == 0)
				return number/10;
			else
				return number%10;
		}
		if (n >= 190 && n <= 2889) { //three digits
			int number = ((n - 187) / 3) + 99;
			if ((n-190) % 3 == 0)
				return number/100;
			if ((n-190) % 3 == 1)
				return (number % 100) / 10;
			else 
				return number % 10;
		}
		if (n >= 2890 && n <= 38889) { //four digits
			int number = ((n - 2886) / 4) + 999;
			if ((n-2890) % 4 == 0)
				return number/1000;
			if ((n-2890) % 4 == 1)
				return (number % 1000) / 100;
			if ((n-2890) % 4 == 2)
				return (number % 100) / 10;
			else 
				return number % 10;
		}
		if (n >= 38890 && n <= 488889) { //five digits
			int number = ((n - 38885) / 5) + 9999;
			if ((n-38890) % 5 == 0)
				return number/10000;
			if ((n-38890) % 5 == 1)
				return (number % 10000) / 1000;
			if ((n-38890) % 5 == 2)
				return (number % 1000) / 100;
			if ((n-38890) % 5 == 3)
				return (number % 100) / 10;
			else 
				return number % 10;
		}
		if (n >= 488890 && n <= 5888889) { //six digits
			int number = ((n - 488884) / 6) + 99999;
			if ((n-38890) % 6 == 0)
				return number/100000;
			if ((n-38890) % 6 == 1)
				return (n % 100000) / 10000;
			if ((n-38890) % 6 == 2)
				return (n % 10000) / 1000;
			if ((n-38890) % 6 == 3)
				return (n % 1000) / 100;
			if ((n-38890) % 6 == 4)
				return (n % 100) / 10;
			else 
				return n % 10;
		}
		return 1;
	}
}
