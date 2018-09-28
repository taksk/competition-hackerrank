import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/non-divisible-subset/problem
//Focus on remainder. Focus on count.
public class NonDivisibleSubset {

    static int nonDivisibleSubset(int k, int[] arr) {
        // Complete this function
        int[] a=new int[k+1];
        int result=0;
        for(int i:arr)a[i%k]++; //Count number by remainder.       
        result+=a[0]==0?0:1;//Only one number can be picked from zero.
        for(int i=1;i<=k/2;i++){
            if(i!=k-i){
                result+= a[i]>a[k-i] ? a[i]:a[k-i];
            }else{
                result+=a[i]==0?0:1; //Only one number can be picked from same ramainder.
            }    
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = nonDivisibleSubset(k, arr);
        System.out.println(result);
        in.close();
    }
}