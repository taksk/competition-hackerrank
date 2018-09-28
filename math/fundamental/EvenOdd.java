import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/even-odd-query/problem
// Think about 3 situations below.
// If A[a] is odd, irrespective of what A[b] is, the answer is odd.
// If a == b, then the answer is even ( as the condition #1 is executed in case the number is odd).
// If A[a+1] == 0, then the answer is odd as x0 = 1.
public class EvenOdd {
    static int[] A;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        A=new int[n];
        for(int i0=0;i0<n;i0++)A[i0]=in.nextInt();
        int q = in.nextInt();
        for(int i1=0;i1<q;i1++){
            int x=in.nextInt();
            int y=in.nextInt();
            System.out.println(find(x,y) ? "Even" : "Odd");
        }
    }
    
    static boolean find(int x,int y){
        if(x>y) return false;
        if(x!=y&&A[x]==0)return false;//For corner case.
        return A[x-1]%2==0;
    }
}