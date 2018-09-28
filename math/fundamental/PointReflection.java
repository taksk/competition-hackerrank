import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/find-point/problem
//Find point reflection point.
public class PointReflection {

    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int px=in.nextInt();
            int py=in.nextInt();
            int qx=in.nextInt();
            int qy=in.nextInt();
           
           System.out.println((2*qx-px)+" "+(2*qy-py));
        }
    }
}