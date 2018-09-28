import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
//No need to do all operations. Just think about result.
//Number of balls in each container won't change. And number of balls in each type won't change.
public class ContainersAndBalls {

    static String organizingContainers(int[][] container) {
        
        // Complete this function
        int n=container.length;
        long[] bcc=new long[n];
        long[] bct=new long[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bcc[i]+=container[i][j];
                bct[i]+=container[j][i];
            }            
        }

        Arrays.sort(bcc);
        Arrays.sort(bct);
        
        for(int i=0;i<n;i++){
            if(bcc[i]!=bct[i])  return "Impossible";  
        } 
        return "Possible";
    }
    
    private static void print(int[][] containers){
        for(int[] c:containers){
            for(int t:c){
                System.out.print(t+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for(int container_i = 0; container_i < n; container_i++){
                for(int container_j = 0; container_j < n; container_j++){
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
