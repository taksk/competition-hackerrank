import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/picking-numbers/problem
//Sum up side by side numbers.
public class PickingNumbers {

    static int pickingNumbers(int[] a) {
        // Complete this function
        int[] freq = new int[100];
        for(int i:a)freq[i]++;
        int result=0;
        for(int i=0;i<freq.length-1;i++){
            if(freq[i]+freq[i+1]>result)result=freq[i]+freq[i+1];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}