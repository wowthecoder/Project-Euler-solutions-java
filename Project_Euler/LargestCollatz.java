//Problem: Which starting number, under one million, produces the longest chain?
import java.util.Scanner;

class LargestCollatz {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt(); //1000000, but I test 13 first
		int[] results = new int[n-1];
		int maxChainLength = 0;
		int maxStartNum = 1;
		for (int i = 1; i < n; i++) {
			int chainLength = 1;
			long x = i;
			while (x != 1) {
				if (x < i) {
					int j = (int)x;
					chainLength += (results[j-1] - 1);
					break;
				}
				if (x % 2 == 0)
					x /= 2;
				else 
					x = 3*x + 1;
				chainLength++;
			}
			results[i-1] = chainLength;
			//System.out.println(i + " : " + results[i-1]);
			if (chainLength > maxChainLength) {
				maxChainLength = chainLength;
				maxStartNum = i;
			}
		}
		System.out.println(maxStartNum + " & " + maxChainLength);
	}
}