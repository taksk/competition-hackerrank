import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/fibonacci-modified/problem
//Squared number is too large for long. So use BigInteger.
public class FibonacciModified {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int n = in.nextInt();
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = new BigInteger(String.valueOf(t1));
        dp[2] = new BigInteger(String.valueOf(t2));
        for(int i=2;i<n;i++){
            dp[i+1] = dp[i-1].add(dp[i].multiply(dp[i]));
        }
        System.out.print(dp[n]);
    }
}