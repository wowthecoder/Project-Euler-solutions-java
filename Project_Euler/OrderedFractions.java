//Problem 71: By listing the set of reduced proper fractions 
//for d ≤ 1,000,000 in ascending order of size, 
//find the numerator of the fraction immediately to the left of 3/7.
import java.util.*;

class OrderedFractions {
	public static void main(String[] args) {
		int numer = 1;
		double threshold = 3.0/7.0;
		double maxUnderThreshold = 0.4;
		for (int d = 2; d <= 1000000; d++) {
			int middle = (int)Math.round((double)d / 7.0) * 3;
			for (int n = middle-1; n <= middle+1; n++) {
				//If GCD of the two numbers is bigger than 1 then the fraction is not reduced
				if (gcd(n,d) == 1) {
					double value = (double)n / (double)d;
					if (value < threshold && value > maxUnderThreshold) {
						numer = n;
						maxUnderThreshold = value;
					}
				}
			}
		}
		System.out.println(numer);//print the numerator
	}	
	//Euclid's algorithm
	static int gcd(int n, int d) {
		if (d == 0)
			return n;
		return gcd(d, n % d);
	}
}