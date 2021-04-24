import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean[] primes = new boolean[10000000];
        for (int i = 0; i < primes.length; i++) {
            primes[i]= true;
        }
        primes[0] = false;
        for (int p = 2; p*p <= 10000000; p++) {
            if (primes[p-1] == true) {
                for (int q = p*p; q <= 10000000; q += p) {
                    primes[q-1] = false;
                }
            }
        }
        List<Integer> primeNum = new ArrayList<>();
        for (int j = 0; j < primes.length; j++) {
            if (primes[j] == true) 
                primeNum.add(j+1);
        }
        for(int a = 0; a < t; a++){
            int n = in.nextInt();
            System.out.println(primeNum.get(n-1));
        }
    }
}
