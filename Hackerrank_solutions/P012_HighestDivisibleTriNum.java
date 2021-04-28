import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            //https://mathschallenge.net/library/number/number_of_divisors
            int x = n;
            while (true) {
                int triangularNum = (x*(x+1))/2;
                if (numberOfDivisors(triangularNum) > n) {
                    System.out.println(triangularNum);
                    break;
                }
                x++;
            }
        }
    }
    
    static int numberOfDivisors(int y) {
        //Break down into prime factors
        List<int[]> primeFactors = new ArrayList<>();
        for (int i = 2; i <= (int)Math.sqrt(y); i++) {
            if (y % i == 0) {
                int[] factorAndPower = {i, 0};
                while (y % i == 0) {
                    factorAndPower[1]++;
                    y /= i;
                }
                primeFactors.add(factorAndPower);
            }
        }
        if (y >= 2)
            primeFactors.add(new int[]{y, 1});
        int count = 1;
        for (int[] factor : primeFactors) {
            count *= (factor[1]+1);
        }
        return count;
    }
}