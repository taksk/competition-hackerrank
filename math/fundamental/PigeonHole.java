import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/maximum-draws/problem
//Example of pigeon hole principle.
public class PigeonHole {

    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int p=in.nextInt();
            System.out.println(p+1);
        }
    }
}