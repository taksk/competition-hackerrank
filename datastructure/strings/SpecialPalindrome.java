import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/special-palindrome-again
public class SpecialPalindrome {

   // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long result = n;
        char[] ca = s.toCharArray();
        
        //even
        for(int i=0; i < n; i++){
            char c = ca[i];
            int dif = 0;
            while(i - dif >= 0 && i + 1 + dif < n){
                if(ca[i-dif] == c && ca[i + 1 + dif] == c){
                    result++;
                    dif++;
                }else{
                    break;
                }
            }
        }
        //odd
        for(int i=1; i < n - 1; i++){
            char c = ca[i-1];
            int dif = 0;
            while(i - 1 - dif >= 0 && i + 1 + dif < n){
                if(ca[i - 1 - dif] == c && ca[i + 1 + dif] == c){
                    result++;
                    dif++;
                }else{
                    break;
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //For local test
        //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        //Scanner scanner = new Scanner(new File("./testdata.txt"));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}