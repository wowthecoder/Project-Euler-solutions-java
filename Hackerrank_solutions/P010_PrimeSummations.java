import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean primes[] = new boolean[1000000];
        long[] consecutiveSums = new long[1000000];
        for (int i = 1; i < primes.length; i++) {
            primes[i] = true;
        }
        for (int p = 2; p*p <= 1000000; p++) {
            if (primes[p-1] == true) {
                for (int q = p*p; q <= 1000000; q += p) {
                    primes[q-1] = false;
                }
            }
        }
        for (int j = 1; j < primes.length; j++) {
            consecutiveSums[j] = consecutiveSums[j-1];
            if (primes[j] == true) 
                consecutiveSums[j] += j+1;
        }
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(consecutiveSums[n-1]);
        }
    }
}