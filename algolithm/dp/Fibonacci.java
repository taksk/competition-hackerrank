import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler002/problem
//Just use 2 variables to calculate fibonacci. No need to create list.
public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum = 2L;
            long a = 1L;
            long b = 2L;
            while(true){
                a += b;
                if(a > n) break;
                if(a%2 == 0) sum += a;

                b += a;
                if(b>n) break;
                if(b%2 == 0) sum += b;˜˜˜˜
            }           
            System.out.println(sum);
        }
    }
}