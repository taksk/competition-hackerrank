import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/world-codesprint-12/challenges/breaking-sticks/problem
//Draw picture and understand how steps will be increased. 
//You don't need to calculate all primes up to 10^12.
public class LongestSequence {
    static long[] primes;
    static int primecnt;

    static long longestSequence(long[] aary) {
        //Return the length of the longest possible sequence of moves.
        long result=0;
        //Generate sieves up to 10^6(N<10^12).
        int maxnum = (int)Math.pow(10,6);
        primecnt = 0;
        primes = new long[maxnum];
        boolean[] isPrime = new boolean[maxnum];
        for(int i=0;i<maxnum;i++){
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        for(long j=2;j<maxnum;j++){
            if(isPrime[(int)j]){
                primes[primecnt++] = j;
                for(long k=2*j;k<maxnum;k+=j){
                    isPrime[(int)k] = false;
                }
            }
        }
        
        //Calcurate result.    
        for(long a:aary){
            List<Long> divs = divisors(a);
            long sticks = 1;
            result+=sticks;
            for(int i=divs.size()-1;i>=0;i--){
                sticks*=divs.get(i);
                result += sticks;
            }
        }
        return result;
    }
    
    static List<Long> divisors(long a){
        List<Long> divs = new ArrayList();
        int pidx=0;
        long current = a;
        while(current > 1 && pidx < primecnt){
            if(current%primes[pidx]==0){
                divs.add(primes[pidx]);
                current /= primes[pidx];
            }else{
                pidx++;
            }
        }
        //If current is not divisible by all primes(<10^6), It is a prime divisor.
        if(current!=1){
            divs.add(current);
        }
        if(a!=1&&divs.isEmpty()){
            divs.add(a);
        }
        return divs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}