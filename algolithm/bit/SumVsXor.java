import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sum-vs-xor/problem
public class SumVsXor {
    private static Map<Integer,Long> bm=new HashMap<Integer,Long>();
    static long solve(long n) {
        // Complete this function
        if(n==0)return 1;
        long result=0;
        int z=0;
        char[] bs=Long.toBinaryString(n).toCharArray();
        for(int i=0;i<bs.length;i++){            
            if(bs[i]=='0')z++;
        }
        return binarymul(z);
    }
    
    static long binarymul(int n){
        if(bm.containsKey(n))return bm.get(n);
        long result=1;
        for(int i=1;i<=n;i++)result*=2;
        bm.put(n,result);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }
}