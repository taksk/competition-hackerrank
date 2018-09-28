import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Knapsack {
    static int n;
    static int w;
    static int[] wary;
    static int[] vary;
    static int[][] mem;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        w = in.nextInt();
        wary = new int[n];
        vary = new int[n];
        mem = new int[n+1][w+1];
        for(int w_i=0; w_i < n; w_i++){
            wary[w_i] = in.nextInt();
        }
        for(int v_i=0; v_i < n; v_i++){
            vary[v_i] = in.nextInt();
        }
        // for(int[] ary:mem){
        //     Arrays.fill(ary,-1);
        // }
        // System.out.print(rec(0,w));
        rec();
    }
    
    // Done by recursive method call.
    // static int rec(int i,int j){
    //     if(mem[i][j] >= 0){
    //         return mem[i][j];
    //     }
    //     int res;
    //     if(i==n){
    //         res = 0;
    //     }else if(j < wary[i]){
    //         res = rec(i+1,j);
    //     }else{
    //         res = Math.max(rec(i+1,j),rec(i+1,j-wary[i]) + vary[i]);
    //     }
    //     mem[i][j] = res;
    //     return res;
    // }
    
    //Done by recurrence formula.
    static void rec(){
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=w;j++){
                if(j < wary[i]){
                    mem[i][j]=mem[i+1][j];
                }else{
                    mem[i][j]=Math.max(mem[i+1][j],mem[i+1][j-wary[i]] + vary[i]);
                }
            }
        }
        System.out.print(mem[0][w]);
    }
}