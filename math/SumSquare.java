import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler006/problem
//Sum of num is n*(n+1)/2. Sum of num square is n*(n+1)*(2*n+1)/6
public class SumSquare {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            long result = n*(n+1)/2*n*(n+1)/2 - n*(n+1)*(2*n+1)/6 ;
            System.out.println(result);
        }
    }
}