import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler007/problem
//Store calculated primes
public class SearchNthPrime {
    static ArrayList<Integer> primes = new ArrayList<>();
    
    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        primes.add(2);
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int primecnt = primes.size();
            int current;
            if(primes.size() > n){
                System.out.println(primes.get(n-1));
                continue;
            }else{
                current = primes.get(primes.size() - 1);
            }           
            while(primecnt < n){
                current++;
                if(isPrime(current)){
                    primecnt++;
                    primes.add(current);
                }
            }
            System.out.println(current);
        }
    }
    
    static boolean isPrime(long n){
        boolean prime = true;
        long sqroot = (long)Math.pow(n,0.5);
        for(int i = 2; i <=sqroot;i++){
            if(n%i == 0){
                prime = false;
                break;
            } 
        }
        return prime;
    }
}