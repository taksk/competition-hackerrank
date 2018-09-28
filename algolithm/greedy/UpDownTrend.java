import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/candies/problem
//Get up and down trend and search demand on the point.
public class UpDownTrend {

    static long candies(int n, int[] arr) {
        int[]dp0=new int[n];//candy counts
        int[]dp1=new int[n];//trend from first to end
        int[]dp2=new int[n];//trend from end to first
        dp1[0]=1;
        dp2[n-1]=1;
        for(int i=1;i<n;i++){
            dp1[i]= arr[i]>arr[i-1]? dp1[i-1]+1 : 1;
        }        
        for(int i=n-2;i>=0;i--){
            dp2[i]= arr[i]>arr[i+1] ? dp2[i+1]+1:1;
        }
        for(int i=0;i<n;i++){
            dp0[i]= dp1[i]>dp2[i] ? dp1[i] : dp2[i];
        }
       
        long result = 0;
        for(int i=0;i<n;i++){
            result+=dp0[i];
        }        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}