import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/reverse-game/problem
//Find the formula in reverse result.
//Formula:After all the reverses, You will have,N,0,N-1,1,N-2,2.... N//2
public class PartialReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();        
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int k = in.nextInt();
            int result = k<n/2 ? 1+2*k : (n-k-1)*2;
            System.out.println(result);            
        }        
    }
}