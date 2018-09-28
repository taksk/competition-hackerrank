import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/contests/hourrank-24/challenges/strong-password/problem
//indexOf() returns "-1" when character not found.
public class StrongPassword {

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        char[] pc=password.toCharArray();
        String  numbers = "0123456789",
                lower_case = "abcdefghijklmnopqrstuvwxyz",
                upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                special_characters = "!@#$%^&*()-+";

        int lacklen=0;
        boolean[] cflg=new boolean[4];
        int lackc=0;
        
        for(char c:pc){
            if(numbers.indexOf(c)>-1)cflg[0]=true;
            if(lower_case.indexOf(c)>-1)cflg[1]=true;
            if(upper_case.indexOf(c)>-1)cflg[2]=true;
            if(special_characters.indexOf(c)>-1)cflg[3]=true;
        }
        
        for(boolean b:cflg){
            if(!b)lackc++;
        }

        lacklen=6-password.length();
        return Math.max(lacklen,lackc);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
