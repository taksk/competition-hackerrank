import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
//Don't forget start point.
public class JumpingCloud {

    static int jumpingOnClouds(int[] c, int k) {
        // Complete this function
        int e=100;
        int idx=0;
        for(int i=0;i<c.length-k;i+=k){
            e--;
            if(c[i+k]==1)e-=2;
        }
        //Final jump to start point.
        e--;
        if(c[0]==1)e-=2;
        return e;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }
}