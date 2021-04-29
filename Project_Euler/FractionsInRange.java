//Problem 73: How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
public class FractionsInRange {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int count = 0;
		//Use Farey's sequence
		//A farey  of order n is the sequence of ordered proper reduced fractions between 0 and 1, 
		//which has a denominator less than or equal to n. 
		//Such an example is given in the problem description which lists F8.
	    //when we have two adjacent fractions a/b and c/d  in a farey  sequence of order n the next one e/f can be calculated as
		//e = floor((n+b)/d)*c - a;
		//f = floor((n+b)/d)*d - b;
		//the first 2 fractions are 1/3 and 4000/11999, then use these two fractions to 
		int a = 1, b = 3;
		int c = 4000, d = 11999;
		final int n = 12000;
		while (!(c == 1 && d == 2)) {
			int x = (int)((n + b) / d);
			int e = x * c - a;
			int f = x * d - b;
			a = c;
			b = d;
			c = e;
			d = f;
			count++;
		}
		System.out.println(count);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed/1000000 + " ms");
	}
}
