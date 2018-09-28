import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/the-time-in-words/problem
public class TimeInWords {

    static String timeInWords(int h, int m) {
        String[] nstr=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine",
                                   "ten","eleven","twenty","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen",
                                   "twenty","twenty one","twenty two","twenty three","twenty four","twenty five","twenty six","twenty seven","twenty eight","twenty nine"};
        String result;
        if(m==0){
            result=nstr[h]+" "+"o' clock";
        }else if(m==30){
            result="half past "+nstr[h];
        }else if(m==15){
            result="quarter past "+nstr[h];
        }else if(m==45){
            result="quarter to "+nstr[h+1];
        }else if(m<30){
            if(m==1){
                result=nstr[m]+" minute past "+nstr[h];
            }else{
                result=nstr[m]+" minutes past "+nstr[h];
            }            
        }else{
            if(m==59){
                result=nstr[60-m]+" minute to "+nstr[h+1];
            }else{
                result=nstr[60-m]+" minutes to "+nstr[h+1];
            }            
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String result = timeInWords(h, m);
        System.out.println(result);
        in.close();
    }
}