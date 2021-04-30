import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            BigInteger result = BigInteger.valueOf(2).pow(N);
            int sumOfDigits = 0;
            String[] digits = result.toString().split("");
            for (String d : digits) {
                int digit = Integer.parseInt(d);
                sumOfDigits += digit;
            }
            System.out.println(sumOfDigits);
        }
    }
}
