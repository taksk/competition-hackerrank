import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//This is implementation for https://www.hackerrank.com/challenges/connecting-towns
//(a*b)%MOD =  ((a % MOD) * (b % MOD)) % MOD

public class ModMultipleFormula {

    static String canConstruct(int[] a) {
        // Return "Yes" or "No" denoting whether you can construct the required number.
        long result=0L;
        for(int i:a){
           result+=i;
       }
       if(result%3==0){
           return "Yes";
       }else{
           return "No";
       }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i = 0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = canConstruct(a);
            System.out.println(result);
        }
        in.close();
    }
}