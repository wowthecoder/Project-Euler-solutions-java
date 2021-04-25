//Problem 69: Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
import java.util.ArrayList;

public class EulerTotientMax {

	public static void main(String[] args) {
		double max = 0;
        int selectedN = 0;
		for (int n = 2; n <= 1000000; n++) {
			double result = (double)n / (double)eulerTotient(n);
			if (result > max)  {
				max = result;
				selectedN = n;
			}
		}
		System.out.println(selectedN);
	}
	
	static long eulerTotient(int num) {
		//Use formula: Φ(n) is equal to n multiplied by product of (1 – 1/p) for all prime factors p of n.
		//For example value of Φ(6) = 6 * (1-1/2) * (1 – 1/3) = 2.
		//So find all prime factors of n first
		int N = num;
		ArrayList<Integer> primeFactors = new ArrayList<>();
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if (num % i == 0)
				primeFactors.add(i);
			while (num % i == 0) {
				num /= i;
			}
		}
		if (num > 2)
			primeFactors.add(num);
		//Now we can do the calculation
		//Use numerator and denominator to avoid floating point calculations
		long numer = 1; 
		long denom = 1;
		for (int p = 0; p < primeFactors.size(); p++) {
			int currentDenom = primeFactors.get(p);
			int currentNumer = currentDenom - 1;
			denom *= currentDenom;
			numer *= currentNumer;
		}
		long ans = (N * numer) / denom;
		return ans;
	}

}
