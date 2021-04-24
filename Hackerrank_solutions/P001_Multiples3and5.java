import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        BigInteger three = new BigInteger("3");
        BigInteger five = new BigInteger("5");
        BigInteger fifteen = new BigInteger("15");
        for(int a = 0; a < t; a++){
            long n = in.nextLong();
            if (n < 3) {
                System.out.println(0);
                continue;
            }
            BigInteger sum = BigInteger.ZERO;
            BigInteger biggestTermOf3 = BigInteger.valueOf((long)((n-1) / 3));
            //sum of arithmetic progression: n/2(a + l)
            BigInteger sumOfMultiplesOf3 = (biggestTermOf3.multiply(three.add(biggestTermOf3.multiply(three)))).divide(BigInteger.valueOf(2));
            sum = sum.add(sumOfMultiplesOf3);
            BigInteger biggestTermOf5 = BigInteger.valueOf((long)((n-1) / 5));
            BigInteger sumOfMultiplesOf5 = (biggestTermOf5.multiply(five.add(biggestTermOf5.multiply(five)))).divide(BigInteger.valueOf(2));
            sum = sum.add(sumOfMultiplesOf5);
            if (n > 15) {
                BigInteger biggestTermOf15 = BigInteger.valueOf((long)((n-1) / 15));
                BigInteger sumOfMultiplesOf15 = (biggestTermOf15.multiply(fifteen.add(biggestTermOf15.multiply(fifteen)))).divide(BigInteger.valueOf(2));
                sum = sum.subtract(sumOfMultiplesOf15);
            }
            System.out.println(sum);
        }
    }
}
