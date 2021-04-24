import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        for(int a = 0; a < t; a++){
            int n = in.nextInt();
            BigInteger N = BigInteger.valueOf(n);
            BigInteger sumSqr = ((N.multiply(N.add(one))).divide(two)).pow(2);
            BigInteger sumOfSqr = (N.multiply(N.add(one)).multiply(two.multiply(N).add(one))).divide(BigInteger.valueOf(6));
            System.out.println(sumSqr.subtract(sumOfSqr));
        }
    }
}
