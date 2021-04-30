import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Precalculate
        BigInteger[][] grid = new BigInteger[500][500];
        for (int i = 0; i < 500; i++) {
            grid[0][i] = BigInteger.valueOf(1);
        }
        for (int j = 0; j < 500; j++) {
            grid[j][0] = BigInteger.valueOf(1);
        }
        for (int r = 1; r < 500; r++) {
            for (int c = 1; c < 500; c++) {
                grid[r][c] = grid[r-1][c].add(grid[r][c-1]);
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            System.out.println(grid[N][M].mod(BigInteger.valueOf(1000000007)));
        }
    }
}
