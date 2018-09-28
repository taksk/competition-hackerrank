import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/p1-paper-cutting/problem
//In 1 cut, Number of piece increases by 1. And we need to make n*m pieces. So that n*m-1 cut is needed.
public class CuttingSquare {

    static long solve(long n, long m){
        // Complete this function
        return n*m-1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long m = in.nextInt();
        long result = solve(n, m);
        System.out.println(result);
    }
}