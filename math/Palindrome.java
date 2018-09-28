import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem
//It passes tests, But more improvement is needed(expecially about palindrome.)
public class Palindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int maxpal = 0;
            int current = 0;
            for(int i = 100;i<1000;i++){
                for(int j =100;j<1000;j++){
                    if(i*j >= n) break;
                    if(i*j > maxpal){
                        if(isPal(i*j)){
                            maxpal = i*j;
                        }
                    }
                }
            }
            System.out.println(maxpal);    
        }
    }
    
    static boolean isPal(int num){
        String str = Integer.toString(num);
        String reverse = new StringBuilder(str).reverse().toString();
        if(str.equals(reverse)){
            return true;
        }else{
            return false;
        }
    }
}
