import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {
    static long[] c;
    static long[][] mem;
    static long getWays(long n, int idx){
        // Complete this function
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(mem[(int)n-1][idx] != -1){
          return mem[(int)n-1][idx];  
        }
        long result = 0;
        for(int i=idx;i<c.length;i++){
            result += getWays(n-c[i],i);
        }
        mem[(int)n-1][idx]=result;
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        c = new long[m];
        mem=new long[n][m];
        for(long[] ary:mem){
            for(int i=0;i<ary.length;i++){
                ary[i] = -1;
            }
        }
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, 0);
        System.out.print(ways);
    }
}
