import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger sum = BigInteger.ZERO;
        while (n-- > 0) {
            BigInteger input = new BigInteger(br.readLine());
            sum = sum.add(input);
        }
        String sumStr = sum.toString();
        System.out.println(sumStr.substring(0, 10));
    }
}
