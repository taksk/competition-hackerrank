import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/world-codesprint-11/challenges/numeric-string/problem
//Timeout code.
public class NumericString {

    // static String getMagicNumber(String s, int k, int b, int m){
    //     // Complete this function
    //     String[] sary = s.split("");
    //     BigInteger result = new BigInteger("0");
    //     BigInteger modulo = new BigInteger(String.valueOf(m));
    //     for(int i=0;i<=s.length()-k;i++){
    //         BigInteger b10 = new BigInteger("0");
    //         for(int j=0;j<k;j++){
    //             if(sary[i+j].equals("0")) continue;
    //             BigInteger toAdd = new BigInteger(String.valueOf(b));
    //             toAdd = toAdd.pow(k-j-1);
    //             toAdd = toAdd.multiply(new BigInteger(sary[i+j]));
    //             b10 = b10.add(toAdd);
    //         }
    //         result = result.add(b10.remainder(modulo));
    //     }
    //     return result.toString();
    // }
    
    static long getMagicNumber(String s, int k, int b, int m){
        // Complete this function
        char[] sary = s.toCharArray();
        long[] bary = new long[k+1];
        long result = 0;
        for(int l=0;l<k+1;l++){
            bary[l] = (long)Math.pow(b,l);
        }
        
        for(int i=0;i<=s.length()-k;i++){
            //generate base convert            
            long b10 = 0;
            for(int j=0;j<k;j++){
                b10 +=(long)Character.getNumericValue(sary[i+j])*bary[k-j-1];
             }
            result += b10 % m;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        long result = getMagicNumber(s, k, b, m);
        System.out.println(result);
    }
}
