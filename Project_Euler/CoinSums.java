//Problem 31: 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
//How many different ways can £2 be made using any number of coins?

public class CoinSums {

	public static void main(String[] args) {
		//https://www.xarg.org/puzzle/project-euler/problem-31/
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int[] targets = new int[201];
		targets[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i < targets.length; i++) {
				if (i >= coin) 
					targets[i] += targets[i-coin];
			}
		}
		System.out.println(targets[200]);
	}

}
