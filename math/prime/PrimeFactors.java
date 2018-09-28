import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler003/problem
//Just count till square root.
public class PrimeFactors {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long target = n;
            long sqroot = (long)Math.pow(n,0.5);
            long maxPrime = 1;
            for(long i = 2;i<=n;i++){
                if(n%i == 0){
                    while(n%i == 0){
                        n = n/i;
                    }
                    sqroot = (long)Math.pow(n,0.5);
                    maxPrime = i;
                }
                if(n==1) break;
                if(i > sqroot){
                    maxPrime = n;
                    break;
                }
            }
            System.out.println(maxPrime);
        }
    }
}
