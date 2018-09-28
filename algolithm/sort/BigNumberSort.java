import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/big-sorting/problem
//BigInteger is fast for calculation such like add, But it's slow for converting to decimal. 
//If digit of number is various, Do not compare number by numeric way,  compare by digit.
public class BigNumberSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n] ;
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        Arrays.sort(unsorted,new StrComparator());
        for(String i:unsorted){
            System.out.println(i);
        }
    }
}

class StrComparator implements Comparator<String>{
        public int compare(String str1, String str2){
            if(str1.length() == str2.length())
                return str1.compareTo(str2);
            else
                return str1.length() - str2.length();
        }
}
