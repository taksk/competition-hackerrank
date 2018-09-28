import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sherlock-and-moving-tiles/problem
//q can be bigger than int range. s2 is not always bigger than s1.
public class MovingTile {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int l=in.nextInt();
        int s1=in.nextInt();
        int s2=in.nextInt();
        int t=in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long q=in.nextLong();
            System.out.println(Math.sqrt(2)*(l-Math.sqrt(q))/Math.abs(s2-s1));           
        }
        in.close();
    }
}