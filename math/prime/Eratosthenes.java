import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PointReflection {
    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int a0 = 0; a0 < t; a0++){
            long start = System.currentTimeMillis();
            int n = in.nextInt();
            int primecnt = 0;
            int maxnum = 2000000;
            int[] primes = new int[maxnum];
            boolean[] isPrime = new boolean[maxnum];
            for(int i=0;i<maxnum;i++){
                isPrime[i] = true;
            }
            isPrime[0] = false;
            isPrime[1] = false;
            for(int j=2;j<maxnum;j++){
                if(isPrime[j]){
                    primes[primecnt++] = j;
                    for(int k=2*j;k<maxnum;k+=j){
                        isPrime[k] = false;
                    }
                }
            }
            System.out.println(System.currentTimeMillis() - start + "ms");
            System.out.println(primes[n-1]);
        }
    }
}