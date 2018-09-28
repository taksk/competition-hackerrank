import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/append-and-delete/problem
//Corner cases.
public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        // Complete this function
        char[] sa =s.toCharArray();
        char[] ta =t.toCharArray();
        int com=0;
        for(int i=0;i<Math.min(sa.length,ta.length);i++){
            if(sa[i]!=ta[i])break;
            com++;
        }
        int add=sa.length-com;
        int del=ta.length-com;

        if(sa.length+ta.length<k)return "Yes";//You can do delete operations as many as you need.
        if(add+del<=k){
            if((k-add-del)%2!=0)return "No";//You can append<->delete operations as many as you need. But it takes 2 steps.
            return "Yes";
        }else{
            return "No";            
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}