import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/challenges/special-multiple/problem
//Think 909990 as 101110*9 and 101110 is bynary representation.
public class BinaryString {
    //Editorial approach.
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);         
        int t = in.nextInt();        
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int b=1;
            while(true){
                long val=Long.parseLong(Integer.toBinaryString(b).replace("1", "9"));
                if(val%n==0){
                    System.out.println(val);
                    break;
                }
                b++;
            }
        }
    }
    
    //My approach.
    //This can be used for larger number groups(not only 9,0 pair)
    public static void main2(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);         
        int t = in.nextInt();        
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            Queue<Long> q = new ArrayDeque<Long>();
            q.add(9L);
            while(!q.isEmpty()){
                long v=q.poll();
                if(v%n==0){
                    System.out.println(v);
                    break;
                }else{
                    q.add(v*10);
                    q.add(v*10+9);
                }
            }
        }
    }
}