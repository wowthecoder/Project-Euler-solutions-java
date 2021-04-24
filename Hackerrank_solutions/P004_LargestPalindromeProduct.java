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
            int n = in.nextInt();
            int largestPalindrome = 0;
            for (int i = 999; i >= 100; i--) {
                if ((n/i) > 999)
                    break;
                for (int j = n/i; j >= 100; j--) {
                    int num = i * j;
                    if (num < largestPalindrome)
                        break;
                    String numStr = Integer.toString(num);
                    StringBuilder numStrReverse = new StringBuilder(numStr);
                    numStrReverse.reverse();
                    if (numStr.equals(numStrReverse.toString()) && num > largestPalindrome && num != n) {
                        largestPalindrome = num;
                    }
                }
            }
            System.out.println(largestPalindrome);
        }
    }
}
