import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        //Precalculate everything
        int[] calculatedCounts = new int[5000000];//Store length of chains from 1 to 5000000
        int maxCount = 0;
        int maxN = 0;
        int[] answers = new int[5000000];
        answers[0] = 1;
        for (int i = 2; i <= 5000000; i++) {
            int count = 0;
            long num = i;
            while (num != 1) {
                if (num % 2 == 1) 
                    num = 3*num + 1;
                else
                    num /= 2;
                count++;
                if (num < i) {
                    count += calculatedCounts[(int)num-1];
                    break;
                }
            }
            calculatedCounts[i-1] = count;
            if (count >= maxCount) {
                maxCount = count;
                maxN = i;
                answers[i-1] = i;
            }
            else
                answers[i-1] = maxN;
        }
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(answers[n-1]);
        }
    }
}
