import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
//Reverse number
public class ReverseNum {

    static int beautifulDays(int i, int j, int k) {
        // Complete this function
        int result=0;
        for(int i0=i;i0<=j;i0++){
            int rev=0;
            char[] ca=String.valueOf(i0).toCharArray();
            for(int i1=ca.length-1;i1>=0;i1--){
                rev= rev*10 + Character.getNumericValue(ca[i1]);
            }
            if(Math.abs(i0-rev)%k==0)result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}