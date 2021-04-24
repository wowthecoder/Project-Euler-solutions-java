import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] divisors = new int[n];
            for (int i = 0; i < n; i++) {
                divisors[i] = i+1;
            }
            System.out.println(lcm(divisors));
        }
    }
    
    static long lcm(int[] divisors) {
        long ans = divisors[0];
        for (int j = 1; j < divisors.length; j++) {
            ans = (ans * divisors[j]) / gcd(ans, divisors[j]);
        }
        return ans;
    }
    
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
