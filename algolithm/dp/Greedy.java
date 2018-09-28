import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/equal/problem
//Count add counts like coin change
//Decleasing difference by adding counts to rest is equivalent to doing by reducing counts from itself.
//If A(n) % 5 = 3 or 4, you can decrease operation by add base 2 or 1 
public class Greedy {
    static final int[] addValue = {1,2,5};
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
         Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[] m = new int[n];
            for(int i = 0;i<n;i++){
                m[i] = in.nextInt();
            } 
            Arrays.sort(m);
            int sum = Integer.MAX_VALUE;
            for(int base = 0; base < 3; base++) {
                int currentsum = 0;
                for(int i = n-1;i >=0 ;i--){
                    currentsum += addCount(m[i] - m[0] + base);     
                }
                sum = Math.min(currentsum,sum);
            }            
            System.out.println(sum);
        }        
    }
    
    
    static int addCount(int diff){
        int result = 0;
        for(int i=2;i>=0;i--){
            result += diff/addValue[i];
            diff = diff % addValue[i];
        }
        return result;
    }
}
