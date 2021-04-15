//Problem: What is the smallest positive number that is 
//evenly divisible by all of the numbers from 1 to 20?
import java.util.Scanner;

class SmallestMultiple {
	//use LCM 
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		long ans = 1;
		for (long i = 2; i <= n; i++) {
			ans = lcm(ans, i);
			System.out.println(ans);
		}
		System.out.println(ans);
	}
	
	static long lcm(long x, long y) {
		return (x*y) / hcf(x,y);
	}
	
	static long hcf(long a, long b) {
		if (b == 0)
			return a;
		return hcf(b, a % b);
	}
}
