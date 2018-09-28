import java.io.*;
import java.util.*;
//https://www.hackerrank.com/challenges/saveprincess2
public class BotSavePrincess2 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n= in.nextInt();
            int my=in.nextInt();
            int mx=in.nextInt();

            int px=-1;
            int py=-1;
            for(int i = 0; i < n; i++) {
                String s = in.next();
                if(s.indexOf('p')!=-1){
                    px=s.indexOf('p');
                    py=i;
                }
            }
            //System.out.println(mx+" "+my+" "+px+" "+py);
            //X move
            if(mx-px>0){
                System.out.println("LEFT");
            }else if(mx-px<0){
                System.out.println("RIGHT");
            }else{
                //Y move            
                if(my-py>0){
                    System.out.println("UP");
                }else if(my-py<0){
                    System.out.println("DOWN");
                }
            }
        }

}