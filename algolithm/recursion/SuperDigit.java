import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/recursive-digit-sum
//Code of '0' is 48
public class SuperDigit {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        if(n.length() == 1)return Integer.parseInt(n);
        long nsum = 0;
        for(int i = 0; i < n.length(); i++){
            nsum += (long)n.charAt(i) - 48L;
        }    
        nsum *= k;        
        return superDigit(String.valueOf(nsum),1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}