import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a = 0; a < t; a++){
            long n = in.nextLong();
            long largestPrimeFactor = 0;
            for (int i = 2; i <= (int)Math.sqrt(n); i++) {
                if (n % i == 0)
                    largestPrimeFactor = i;
                while (n % i == 0) {
                    n /= i;
                }
            }
            if (n > 2 && n > largestPrimeFactor)
                largestPrimeFactor = n;
            System.out.println(largestPrimeFactor);
        }
    }
}
