//Problem 67: Harder version of problem 18

import java.io.*;

public class MaxPathSumII {

	public static void main(String[] args) {
		try {
			File file = new File("p067_triangle.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			long[][] triangle = new long[100][100];
			String line = "";
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] numStr = line.split(" ");
				for (int col = 0; col < numStr.length; col++) {
					triangle[row][col] = Long.parseLong(numStr[col]);
				}
				row++;
			}
			for (int r = triangle.length-2; r >= 0; r--) {
				for (int c = r; c >= 0; c--) {
					triangle[r][c] = triangle[r][c] + Math.max(triangle[r+1][c], triangle[r+1][c+1]);
				}
			}
			System.out.println(triangle[0][0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
