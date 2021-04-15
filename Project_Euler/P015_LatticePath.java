//Problem 15
import java.util.Scanner;

class LatticePath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		long[][] map = new long[h+1][w+1];
		//initialise all top and left most cells 1
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if (r == 0 || c == 0) 
					map[r][c] = 1;
				else
					map[r][c] = 0;
			}
		}
		//sum all intersection points up
		for (int row = 1; row < map.length; row++) {
			for (int col = 1; col < map[0].length; col++) {
				map[row][col] = map[row][col-1] + map[row-1][col];
			}
		}
		System.out.println(map[h][w]);
	}
}
