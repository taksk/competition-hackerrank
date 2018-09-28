import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/luck-balance
public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int result = 0;
        int lose = 0;
        int lmin = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int[] c:contests){
            int l = c[0];
            int t = c[1];
            System.out.println(l + " " + t + ":" + pq.size() + "/" + pq.peek());
            
            if(t == 1){
                if(pq.size() < k){
                    pq.add(l);
                    result += l;
                }else{
                    if(k == 0){
                        result -= l;
                        continue;
                    }
                    if(l > pq.peek()){
                        result -= 2 * pq.poll();
                        result += l;
                        pq.add(l);
                    }else{
                        result -= l;
                    }
                }
            }else{
                result += l;
            }         
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
