import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DivisorCombination {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();        
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            if(n%2==1){
                System.out.println(0);
                continue;
            }
            //Search prime divisors.
            Map<Integer,Integer> divs = new HashMap<Integer,Integer>();
            int root=(int)Math.sqrt(n);
            for(int i1=2;i1<=root +1;i1++){
                while(n%i1==0){
                    n/=i1;                    
                    divs.put(i1, divs.containsKey(i1) ? divs.get(i1)+1:1);
                }
                if(n==1)break;                
            }
            if(n!=1)divs.put(n,1);//last n is also a prime divisor.
            
            //Count divisors.
            int result=divs.get(2);
            divs.remove(2);
            for(int i2:divs.keySet())
                result*=divs.get(i2)+1;
            System.out.println(result);
        }    
    }
}