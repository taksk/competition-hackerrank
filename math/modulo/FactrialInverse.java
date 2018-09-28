import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//This is a solution for https://www.hackerrank.com/contests/hourrank-25/challenges/maximum-palindromes/problem
//Multiply modular inverse, instead of division.
public class FactrialInverse {
    static int[][] cnt;
    static int[] fact;
    static int[] inv;
    static int[] invfact;
    static final int MOD = 1000000007;
    
    static int mul(int a,int b){
        return (int)((long)a*b%MOD);
    }
    
    static void initialize(String s) {
        // This function is called once before all queries.
        // Store char numbers in every phase.
        int n=s.length();
        cnt=new int[26][n+1];
        char[] c=s.toCharArray();
        for(int i=0;i<n;i++){
            for(int j=0;j<26;j++){
                if(c[i]-'a'==j){
                    cnt[j][i+1]=cnt[j][i]+1;
                }else{
                    cnt[j][i+1]=cnt[j][i];
                }
            }
        }
        
        //Calculate factorials and modular inverse.
        fact=new int[n+1];
        inv=new int[n+1];
        invfact=new int[n+1];
        inv[1]=1;
        for (int i=2;i<=n;i++) {
            inv[i] = mul(MOD - MOD / i, inv[(int)(MOD%i)]);
        }
        fact[0]=1;
        invfact[0]=1;
        for (int i=1;i<=n;i++) {
            fact[i] = mul(fact[i - 1], i);
            invfact[i] = mul(invfact[i - 1], inv[i]);
        }
    }


    static int answerQuery(int l, int r) {
    // Return the answer for this query modulo 1000000007.
        int odd=0;
        int all=0;
        int[] cnta=new int[26];
        int result = 1;
        for(int i=0;i<26;i++){
           cnta[i]=cnt[i][r]-cnt[i][l-1];
        }
        for(int i=0;i<26;i++){
            if(cnta[i]%2!=0){
                odd++;
            }
            int d=cnta[i]/2;
            all+=d;
            result=mul(result,invfact[d]);
        }
        result = mul(result,fact[all]);
        if(odd>0)result = mul(result,odd);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        initialize(s);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int l = in.nextInt();
            int r = in.nextInt();
            int result = answerQuery(l, r);
            System.out.println(result);
        }
        in.close();
    }
}