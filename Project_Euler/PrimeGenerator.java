//Problem: Find the 10001st prime
import java.util.Scanner;

class PrimeGenerator {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();
		boolean[] prime = new boolean[10000000];
		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}
		prime[0] = false;
		prime[1] = false;
		for (int p = 2; p*p < 10000000; p++) {
			if (prime[p] == true) {
				//update all multiples of p
				for (int j = p*p; j < 10000000; j += p) {
					prime[j] = false;
				}
			}			
		}
		int termNum = 0;
		for (int k = 0; k < prime.length; k++) {
			if (prime[k] == true) 
				termNum++;
			if (termNum == n) {
				System.out.println(k);
				break;
			}
		}
	}
}