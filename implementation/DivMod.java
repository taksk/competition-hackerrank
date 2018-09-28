import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/chocolate-feast/problem
public class DivMod {

    static int chocolateFeast(int n, int c, int m) {
        // Complete this function
        int result=n/c;
        int uc=n/c;        
        while(uc>=m){            
            result+=uc/m;
            uc=uc/m+uc%m;            
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            int result = chocolateFeast(n, c, m);
            System.out.println(result);
        }
        in.close();
    }
}