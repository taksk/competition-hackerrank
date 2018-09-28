import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/linkedin-practice-dynamic-programming-lcs/problem
//Find lcs string.
//Advanced version of lcs string length.
public class Lcs {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] seqa = new int[n];
        int[] seqb = new int[m];
        List<Integer>[][] lcs = new ArrayList[n+1][m+1];
        for(int i1=0;i1<=n;i1++){
            for(int j1=0;j1<=m;j1++){
                lcs[i1][j1] = new ArrayList<Integer>();
            }
        }
        for(int i=0;i<n;i++){
            seqa[i]=in.nextInt();
        }
        for(int j=0;j<m;j++){
            seqb[j]=in.nextInt();
        }
        
        //Lcs
        for(int k=0;k<n;k++){
            for(int l=0;l<m;l++){
                int maxaround = Math.max(lcs[k][l+1].size(),lcs[k+1][l].size());
                if(seqb[l]==seqa[k]){
                    if(lcs[k][l].size() +1 > maxaround){
                        lcs[k+1][l+1].addAll(lcs[k][l]);
                        lcs[k+1][l+1].add(seqb[l]);
                    }else if(lcs[k][l+1].size() == maxaround){
                        lcs[k+1][l+1].addAll(lcs[k][l+1]); 
                    }else if(lcs[k+1][l].size() == maxaround){
                        lcs[k+1][l+1].addAll(lcs[k+1][l]);
                    }
                }else{
                    if(lcs[k][l+1].size() == maxaround){
                        lcs[k+1][l+1].addAll(lcs[k][l+1]); 
                    }else if(lcs[k+1][l].size() == maxaround){
                        lcs[k+1][l+1].addAll(lcs[k+1][l]);
                    }
                }
                for(int i:lcs[k+1][l+1]) System.out.print(i);
            }
        }
        for(int i:lcs[n][m]) System.out.print(i + " ");
    }
}