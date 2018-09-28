import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sam-and-substrings/problem
//Think about modulo rule. 
//a+b mod n = ((a mod n) + (b mod n)) mod n
//ab mod n = (a mod n)*(b mod n) mod n
//mod 10^9+7 is not bigger than int range.
public class SumSubString {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int[] s = Arrays.stream(in.next().split("")).mapToInt(Integer::parseInt).toArray();
        long mod = 1000000007L;
        long result =0;
        long f = 1;
        for(int i=s.length-1;i>=0;i--){
            result = (result + s[i]*(i+1)*f) % mod;
            //result = (result +((s[i]*(i+1) % mod)*f %mod)) % mod;//result = sum(i-1) % mod, f=f(i)
            f = (f*10+1) % mod;
        }
        System.out.println(result);
    }
}
