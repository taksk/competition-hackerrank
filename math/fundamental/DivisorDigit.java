import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/best-divisor/problem
//To get digit calculate i%10
public class DivisorDigit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> divl=getDiv(n);
        List<Integer> digsl=getDigSum(divl);
        int max=0;
        int idx=-1;
        for(int i=digsl.size()-1;i>=0;i--){
            if(digsl.get(i)>=max){
                max=digsl.get(i);
                idx=i;
            }
        }
        System.out.println(divl.get(idx));
    }
    
    static List<Integer> getDiv(int n){
        List<Integer> resl=new ArrayList<Integer>();
        for(int i=1;i<=n/2;i++){
            if(n%i==0)resl.add(i);
        }
        resl.add(n);        
        return resl;
    }
    
    static List<Integer> getDigSum(List<Integer> divl){
        List<Integer> digsl=new ArrayList<Integer>();
        for(int i:divl){
            int digsum=0;
            while(i>0){
                digsum+=i%10;
                i/=10;
            }
            digsl.add(digsum);
        }
        return digsl;
    }
}