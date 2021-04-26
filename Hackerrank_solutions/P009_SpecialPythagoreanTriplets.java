import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<long[]> triplets = new ArrayList<>();
        List<Long> perimeters = new ArrayList<>();
        long m = 2;
        while (m*m <= 1500) {
            for (long n = 1; n < m; n++) {
                long perim = 2*m*m + 2*m*n;
                if (perim > 3000)
                    break;
                long a = m*m - n*n;
                long b = 2*m*n;
                if (gcd(a, b) != 1)
                    continue;
                long c = m*m + n*n;
                long[] triplet = {a, b, c};
                triplets.add(triplet);
                perimeters.add(perim);
            }
            m++;
        }
        for(int test = 0; test < t; test++){
            int n = in.nextInt();
            long maxProduct = -1;
            for (int i = 0; i < perimeters.size(); i++) {
                if (n % perimeters.get(i) == 0) {
                    long[] primeTriplet = triplets.get(i);
                    long factor = n / perimeters.get(i);
                    long a = primeTriplet[0] * factor;
                    long b = primeTriplet[1] * factor;
                    long c = primeTriplet[2] * factor;
                    long product = a * b * c;
                    if (product > maxProduct)
                        maxProduct = product;
                }
            }
            System.out.println(maxProduct);
        }
    }
    
    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}