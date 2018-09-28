import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/handshake/problem
//Sum up n,n-1...,1.
public class Counting {

    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n=in.nextInt();
            System.out.println(n*(n-1)/2);
        }
    }
}