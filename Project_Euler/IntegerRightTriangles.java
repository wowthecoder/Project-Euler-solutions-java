//Problem 39: If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
//{20,48,52}, {24,45,51}, {30,40,50}
//For which value of p <= 1000, is the number of solutions maximised?
import java.util.ArrayList;

public class IntegerRightTriangles {

	public static void main(String[] args) {
		// a2 + b2 = c2 can be written as (m2-n2)^2 + (2mn)^2 = (m2 + n2)^2
		//where a = m2 - n2; b = 2mn, c = m2 + n2, m and n are integers
		//to generate prime triplets, (eg. 3,4,5 not 6,8,10), a and b must be relatively prime to each other
		ArrayList<int[]> triplets = new ArrayList<>();
		ArrayList<Integer> perimeters = new ArrayList<>();
		int m = 2;
		//perimeter is m2 - n2 + 2mn + m2 + n2 = 2m2 + 2mn
		//2m2 <= 1000, m2 <= 500
		while (m*m <= 1000) {
			for (int n = 1; n < m; n++) {
				int perim = 2*m*m + 2*m*n;
				if (perim > 1000)
					break;
				int a = m*m - n*n;
				int b = 2*m*n;
				if (gcd(a, b) != 1)
					continue;
				int c = m*m + n*n;
				int[] triplet = {a, b, c};
				triplets.add(triplet);
				perimeters.add(perim);
			}
			m++;
		}
		int maxP = 0;
		int maxCount = 0;
		for (int p = 12; p <= 1000; p++) {
			int count = 0;
			for (int perim : perimeters) {
				if (p % perim == 0)
					count++;
			}
			if (count > maxCount) {
				maxCount = count; 
				maxP = p;
			}
		}
		System.out.println(maxP);
	}

	static int gcd(int a, int b) {
		if (b == 0) 
			return a;
		return gcd(b, a % b);
	}
}
