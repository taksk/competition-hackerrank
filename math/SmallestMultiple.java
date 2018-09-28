import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
//Smallest divisible by all numbers in 1 to N

public class SmallestMultiple {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            int[] primes = getPrimeList(n);
            int[] max = new int[primes.length];
            //Find maximum integer prime powers
            for(int i = 0;i<primes.length;i++){
                int current = primes[i];
                while(true){
                    if(current * primes[i] <= n){
                        current *= primes[i];
                    }else{
                        break;
                    }
                }
                max[i] = current;
            }
            long result = 1;
            //Multiple maximum prime powers
            for(int j:max) result *= j;
            System.out.println(result);
        }
    }
    
    //Get prime list not exeeds max.
    static int[] getPrimeList(int max){
        List<Integer> primes = new ArrayList<Integer>();
        for(int i = 2;i<=max;i++){
            if(isPrime(i)) primes.add(i);
        }
        int[] result = new int[primes.size()];
        for(int j = 0;j<primes.size();j++){
            result[j] = primes.get(j);
        }
        return result;
    }
    
    static boolean isPrime(int n){
        boolean prime = true;
        int sqroot = (int)Math.pow(n,0.5);
        for(int i = 2; i <=sqroot;i++){
            if(n%i == 0){
                prime = false;
                break;
            } 
        }
        return prime;
    }
    
}
