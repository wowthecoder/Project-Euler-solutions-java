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
            int k = in.nextInt();
            String num = in.next();
            String subStr = num.substring(0, k);
            String[] digitStore = subStr.split("");
            BigInteger currentProduct = new BigInteger("1");
            for (int j = 0; j < k; j++) {
                currentProduct = currentProduct.multiply(new BigInteger(digitStore[j]));
            }
            BigInteger maxProduct = currentProduct;
            for (int i = 1; i <= n-k; i++) {
                subStr = num.substring(i, i+k);
                String[] digit = subStr.split("");
                if (digitStore[0].equals("0")) {
                    currentProduct = new BigInteger("1");
                    for (int q = 1; q < digitStore.length; q++) {
                        currentProduct = currentProduct.multiply(new BigInteger(digitStore[q]));
                    }
                }
                else {
                    currentProduct = currentProduct.divide(new BigInteger(digitStore[0]));
                }
                currentProduct = currentProduct.multiply(new BigInteger(digit[k-1]));
                if (currentProduct.compareTo(maxProduct) == 1)
                    maxProduct = currentProduct;
                //move the digits in digits array forward
                for (int m = 0; m < digitStore.length-1; m++) {
                    digitStore[m] = digitStore[m+1];
                }
                digitStore[k-1] = digit[k-1];
            }
            System.out.println(maxProduct);
        }
    }
}