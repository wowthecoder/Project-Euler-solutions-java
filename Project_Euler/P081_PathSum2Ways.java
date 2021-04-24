//Problem 81: Find the minimal path sum from the top left to the bottom right by only moving right and down 
//in matrix.txt (right click and "Save Link/Target As..."),a 31K text file containing an 80 by 80 matrix.

import java.io.*;

public class PathSum2Ways {

	public static void main(String[] args) {
		try {
			File file = new File("p081_matrix.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			long minSum = 0;
			long[][] matrix = new long[80][80];
			String line = "";
			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] numStr = line.split(",");
				for (int col = 0; col < 80; col++) {
					matrix[row][col] = Long.parseLong(numStr[col]);
				}
				row++;
			}
			//start from destination(bottom right), build up the table
			//fill up the right most column and the bottom most row first
			for (int rowNum = matrix.length-2; rowNum >= 0; rowNum--) {
				matrix[rowNum][79] += matrix[rowNum+1][79];
			}
			for (int colNum = matrix.length-2; colNum >= 0; colNum--) {
				matrix[79][colNum] += matrix[79][colNum+1];
			}
			//Do the rest of the matrix
			for (int r = matrix.length-2; r >= 0; r--) {
				for (int c = matrix.length-2; c >= 0; c--) {
					matrix[r][c] = matrix[r][c] + Math.min(matrix[r+1][c], matrix[r][c+1]);
				}
			}
			System.out.println(matrix[0][0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
