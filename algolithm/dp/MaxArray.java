import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/max-array-sum
//Think parial array from index 0,1. Calculate maximum value of current position.
public class MaxArray {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = Math.max(0,arr[0]);
        dp[1] = Math.max(dp[0],arr[1]);
        for(int i=2; i<dp.length;i++)dp[i] = Math.max(dp[i-1],Math.max(arr[i],arr[i] + dp[i-2]));
        return dp[dp.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}