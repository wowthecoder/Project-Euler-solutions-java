//Problem 18: Find the maximum total from top to bottom of the triangle below:
import java.io.*;

class MaxPathSum {
	public static void main(String[] args) {
		int[][] triangle = new int[15][15];
		//fill all values with default zero
		for (int i = 0; i < 15; i++) {
			 for (int j = 0; j < 15; j++) {
				 triangle[i][j] = 0;
			 }
		}
		//fill up the triangle in the form of 
		//1 0 0
		//2 3 0
		//4 5 6
		try {
			File file = new File("p018_triangle.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] numbers = line.split(" ");
				for (int k = 0; k < numbers.length; k++) {
					int num = Integer.parseInt(numbers[k]);
					triangle[row][k] = num;
				}
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Work up from the bottom
		for (int r = triangle.length-2; r >= 0; r--) {
			for (int c = 0; c < triangle[r].length-1; c++) {
				triangle[r][c] += Math.max(triangle[r+1][c], triangle[r+1][c+1]);
			}
		}
		System.out.println(triangle[0][0]);
	}
}