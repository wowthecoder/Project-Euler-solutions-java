//Problem 11:  What is the greatest product of four adjacent numbers 
//in the same direction 
//(up, down, left, right, or diagonally) in the 20×20 grid?
import java.io.*;

class LargestInGrid {
	public static void main(String[] args) {
		try {
			File file = new File("p011_grid.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			int[][] grid = new int[20][20];
			int row = 0;
			String line = "";
			while ((line = br.readLine()) !=  null) {
				String[] numberStr = line.split(" ");
				for (int i = 0; i < numberStr.length; i++) {
					int n = Integer.parseInt(numberStr[i]);
					grid[row][i] = n;
				}
				row++;
			}
			int maxProduct = 1;
			for (int r = 0; r < grid.length; r++) {
				for (int c = 0; c < grid.length; c++) {
					int downProduct = 1;
					int rightProduct = 1;
					int upRightDiagonal = 1;
					int downRightDiagonal = 1;
					if (r <= grid.length - 4) 
						downProduct = grid[r][c] * grid[r+1][c] * grid[r+2][c] * grid[r+3][c];
					if (c <= grid[r].length - 4) 
						rightProduct = grid[r][c] * grid[r][c+1] * grid[r][c+2] * grid[r][c+3];
					if (r >= 3 && c <= grid[r].length - 4) 
						upRightDiagonal = grid[r][c] * grid[r-1][c+1] * grid[r-2][c+2] * grid[r-3][c+3];
					if (r <= grid.length - 4 && c <= grid[r].length - 4) 
						downRightDiagonal = grid[r][c] * grid[r+1][c+1] * grid[r+2][c+2] * grid[r+3][c+3];
					
					if (downProduct > maxProduct)
						maxProduct = downProduct;
					if (rightProduct > maxProduct)
						maxProduct = rightProduct;
					if (upRightDiagonal > maxProduct)
						maxProduct = upRightDiagonal;
					if (downRightDiagonal > maxProduct)
						maxProduct = downRightDiagonal;
				}
			}
			System.out.println(maxProduct);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
