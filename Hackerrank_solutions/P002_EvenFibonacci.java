import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //1,1,2,3,5,8,13,21,34,55,89,144
    //Notice every three numbers is even
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a = 0; a < t; a++){
            long n = in.nextLong();
            BigInteger sum = BigInteger.ZERO;
            long currentTerm = 2;
            long plusWhat = 0;
            while (true) {
                //Use formula
                if (currentTerm > n)
                    break;
                sum = sum.add(BigInteger.valueOf(currentTerm));
                long nextTerm = 4 * currentTerm + plusWhat;
                plusWhat = currentTerm;
                currentTerm = nextTerm;
            }
            System.out.println(sum);
        }
    }
}
