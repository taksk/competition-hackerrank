import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sherlock-and-cost/problem
public class SherlockAndCost {
    static int[][] a;
    static int[] b;
    static int n;
    static int m;
    static int[][] dp;
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int j=0;j<n;j++){
            m = in.nextInt();
            a = new int[m][2];
            b = new int[m];
            dp = new int[m][100005];
            for(int b_i=0;b_i<m;b_i++){
                b[b_i] = in.nextInt();
            }
            for(int i=0;i<m-1;i++){
                a[i+1][0]=Math.max(a[i][0],a[i][1]+Math.abs(b[i]-1));
                a[i+1][1]=Math.max(a[i][0] + Math.abs(b[i+1]-1),a[i][1]+Math.abs(b[i+1]-b[i]));
            }
            System.out.println(Math.max(a[m-1][0],a[m-1][1]));
            
            //TODO:Test for recursive call.
            // if(m==1){
            //     System.out.println(b[0]);
            // }else{
            //     System.out.println(Math.max(rec(1,1),rec(1,b[0])));
            // }
        }
    }
    
    //TODO:Write as recursive call
    // static int rec(int idx,int bef){
    //     if(dp[idx][bef] != 0){
    //         return dp[idx][bef];
    //     }
    //     int result = 0;
    //     if(idx == m-1){
    //         return Math.max(Math.abs(1-bef),Math.abs(b[idx]-bef));
    //     }
    //     result += Math.max(
    //         rec(idx+1,1) + Math.abs(bef -1),//a[idx] = 1
    //         rec(idx+1,b[idx]) + Math.abs(bef - b[idx])//a[idx] = b[idx]
    //         );
    //     dp[idx][bef] = result;
    //     return result;
    // }
}