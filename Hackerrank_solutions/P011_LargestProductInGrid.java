import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for(int grid_i=0; grid_i < 20; grid_i++){
            for(int grid_j=0; grid_j < 20; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        int maxProduct = 0;
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                if (c <= 16) {
                    int horizontalProduct = grid[r][c] * grid[r][c+1] * grid[r][c+2] * grid[r][c+3];
                    if (horizontalProduct > maxProduct)
                        maxProduct = horizontalProduct;
                }
                if (r <= 16) {
                    int verticalProduct = grid[r][c] * grid[r+1][c] * grid[r+2][c] * grid[r+3][c];
                    if (verticalProduct > maxProduct)
                        maxProduct = verticalProduct;
                }
                if (c <= 16 && r <= 16) {
                    int rightDownDiagonal = grid[r][c] * grid[r+1][c+1] * grid[r+2][c+2] * grid[r+3][c+3];
                    if (rightDownDiagonal > maxProduct)
                        maxProduct = rightDownDiagonal;
                }
                if (c <= 16 && r >= 3) {
                    int rightUpDiagonal = grid[r][c] * grid[r-1][c+1] * grid[r-2][c+2] * grid[r-3][c+3];
                    if (rightUpDiagonal > maxProduct)
                        maxProduct = rightUpDiagonal;
                }
            }
        }
        System.out.println(maxProduct);
    }
}
