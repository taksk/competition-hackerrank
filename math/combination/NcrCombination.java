import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/sherlock-and-permutations/problem
//nCr = n-1Cr + n-1Cr-1
public class NcrCombination {
    static int mod=1000000007;
    static int[][] dp=new int[2000][2000];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int m = in.nextInt();
                          
            System.out.println(ncrComb(n+m-1,n));
        }
    }
    static int ncrComb(int n,int r){
        if(dp[n][r]!=0)return dp[n][r];
        
        int result =0;
        if(n==r||r==0){
            result=1;
        }else{
            result = (ncrComb(n-1,r)%mod+ncrComb(n-1,r-1)%mod)%mod;
        }
        dp[n][r]=result;            
        return result;
    }
}