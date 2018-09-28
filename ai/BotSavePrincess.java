import java.io.*;
import java.util.*;

public class BotSavePrincess {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n;
            n = in.nextInt();
            int mx=-1;
            int my=-1;
            int px=-1;
            int py=-1;
            String grid[] = new String[n];
            for(int i = 0; i < n; i++) {
                String s = in.next();
                if(s.indexOf('m')!=-1){
                    mx=s.indexOf('m');
                    my=i;
                }else if(s.indexOf('p')!=-1){
                    px=s.indexOf('p');
                    py=i;
                }
            }
            //X move
            if(mx-px>0){
                for(int i=0;i<mx-px;i++)System.out.println("LEFT");
            }else if(mx-px<0){
                for(int i=0;i<px-mx;i++)System.out.println("RIGHT");
            }
            
            //Y move
            if(my-py>0){
                for(int i=0;i<my-py;i++)System.out.println("UP");
            }else if(my-py<0){
                for(int i=0;i<py-my;i++)System.out.println("DOWN");
            }
            //System.out.println(mx+" "+my+" "+px+" "+py);

        }

}