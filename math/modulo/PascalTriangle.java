import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/matrix-tracing/problem
//You can find the number in Pascal triangle. And answer is combination (n+m-2)C(n-1).
//To calculate modulo of combination, Multiple facatorial inverse instead of division.
public class PascalTriangle {
    static int MOD=1000000007;
    static int[] fact;
    static int[] inv;
    static int[] invfact;
    public static void main(String[] args) {
        invFact();
         Scanner in = new Scanner(System.in);         
        int t = in.nextInt();        
        for(int i=0;i<t;i++){
            int m=in.nextInt();
            int n=in.nextInt();            
            System.out.println(mul(mul(fact[m+n-2],invfact[m-1]),invfact[n-1]));
        }
    }
    
    static void invFact(){   
        //Caluculate factorial inverse
        int f=1000000*2;
        fact=new int[f+1];
        inv=new int[f+1];
        invfact=new int[f+1];
        inv[1]=1;
        for (int i=2;i<=f;i++) {
            inv[i] = mul(MOD - MOD / i, inv[(int)(MOD%i)]);
        }
        fact[0]=1;
        invfact[0]=1;
        for (int i=1;i<=f;i++) {
            fact[i] = mul(fact[i - 1], i);
            invfact[i] = mul(invfact[i - 1], inv[i]);
        }        
    }
    
    static int mul(int a,int b){
        return (int)((long)a*b%MOD);
    }   
    
}
