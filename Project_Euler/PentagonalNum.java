//Problem 44: Find the pair of pentagonal numbers, Pj and Pk, 
//for which their sum and difference are pentagonal 
//and D = |Pk − Pj| is minimised; what is the value of D?

class PentagonalNum {
	public static void main(String[] args) {
		for (int i = 1; i <= 10000; i++) {
			int diff = (i*(3*i - 1)) / 2;
			for (int j = 1; j <= 10000; j++) {
				int currentTerm = (j*(3*j - 1))/2;
				int potentialPair = currentTerm + diff;
				if (isPentagonal(potentialPair) && isPentagonal(currentTerm + potentialPair)) {
					System.out.println(diff);
					return;
				}
			}
		}
	}
	
	static boolean isPentagonal(int x) {
		x *= 2;
		//Check if n(3n-1) = 2x have an integer solution for n
		//Let f(x) = n(3n-1) = 3n^2 - n = 3(n- 1/6)^2 - 1/12, then inverse the function
		//if f^-1(given_number) = n where n is an integer then the given_number is pentagonal
		//f^-1(x) = (sqrt(12x+1) / 6) + 1/6
		int numer = 12*x + 1;
		double sqrtNumer = Math.sqrt(numer);
		double sqrtDenom = 6.0; 
		if ((int)sqrtNumer != sqrtNumer)
			return false;
		double finalNum = (sqrtNumer + 1) / sqrtDenom;
		if ((int)finalNum == finalNum)
			return true;
		return false;
	}
}