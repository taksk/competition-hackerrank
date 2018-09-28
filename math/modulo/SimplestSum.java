import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimplestSum {
       static long MOD=1000000007L;
    static long simplestSum(int k, long a, long b) {
        // Complete this function
        long result=0L;
        boolean started=false;
        long idx=1;
        long range=1;
        long val=1;
        long delta=1;
        while(true){
            range*=k;
            //range=mul(range,k);
            idx+=range;
            //idx=sum(idx,range);
            System.out.println("idx:"+idx+" range:"+range+" val:"+val);
            
            if(started){
                //System.out.println("result before final:"+result);
                if(idx<=b){
                    //System.out.print("mul:range%mod "+range%MOD+" val%MOD "+val%MOD+" mod*mod:"+ (range%MOD)*(val%MOD) +" mulResult:"+mul(range,val)+" Sum:"+sum(result,mul(range,val))+" ");
                    result=sum(result,mul(range,val));
                }else{
                    //System.out.println("final add:"+mul(-1L,mul(idx-b-1,val)));
                    //System.out.println("final result:"+sum(result,mul(-1L,mul(idx-b-1,val))));
                    long cnt = b+1L-idx+range;
                    //long cnt = sum(sum(sum(b,1),mul(-1L,idx)),range);
                    result=sum(result,mul(cnt,val));
                    break;
                }
            }
            //A to first block.
            if(!started&&idx>a){
                started=true;
                if(idx<=b){
                    result=sum(result,mul(sum(idx,-a),val));
                }else{
                    result=sum(result,mul(sum(sum(b,-a),1L),val));
                    //System.out.println("result:"+result);
                    break;
                }
            }
            delta=delta*k+1;
            val+=delta;
            System.out.println("result:"+result);
        }
        
        return result;
    }

    static long mul(long a,long b){
        long result=((a%MOD)*(b%MOD))%MOD;
        return result;
    }   
    
    static long sum(long a,long b){
        long result=((a%MOD)+(b%MOD))%MOD;
        System.out.println("sum result:"+result);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            long a = in.nextLong();
            long b = in.nextLong();
            long result = simplestSum(k, a, b);
            System.out.println(result);
        }
        in.close();
    }
}