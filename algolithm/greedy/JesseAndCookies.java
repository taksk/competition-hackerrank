import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class JesseAndCookies {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
         int result = 0;
         PriorityQueue<Integer> q = new PriorityQueue<Integer>();
         for(int i:A){
             q.add(i);
         }
         while(true){
             if(q.size() == 1){
                 if(q.peek() < k){
                     result = -1;
                 }
                 break;
             }
             if(q.peek() < k){
                 q.add(q.poll() + 2 * q.poll());
                 result += 1;
             }else{
                 break;
             }
         }
         
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //For local test
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}