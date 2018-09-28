import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd/problem
//Euclid's Division Lemma
public class Gcd {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(euclidDiv(a,b));
    }
    
    static int euclidDiv(int a,int b){
        if(b == 0) return a;
        int mod = a%b;
        return euclidDiv(b,mod);
    }
}