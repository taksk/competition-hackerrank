import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/contests/world-codesprint-12/challenges/red-knights-shortest-path/problem
//Find shortest path by Bfs.
public class Bfs {
    static Map<String,Pair> steps;
    static Map<String,String> history;
    static int i_end;
    static int j_end;
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        //  Print the distance along with the sequence of moves.
        history = new HashMap<String,String>();
        // Move pattern.
        steps = new LinkedHashMap<String,Pair>();
        steps.put("UL",new Pair(-2,-1));
        steps.put("UR",new Pair(-2,1));
        steps.put("R",new Pair(0,2));
        steps.put("LR",new Pair(2,1));
        steps.put("LL",new Pair(2,-1));
        steps.put("L",new Pair(0,-2));
        Queue<Pair> q = new ArrayDeque<Pair>();

        //Impossible check
        if(!(Math.abs(i_end-i_start)%4==0 
            && Math.abs(j_end-j_start)%2==0)
            && 
            !(Math.abs(i_end-i_start)%4==2
            && Math.abs(j_end-j_start)%2==1)){
            System.out.println("Impossible");
            return;
        }
        
        q.add(new Pair(i_start,j_start));
        history.put(i_start +"-"+j_start,"");

        //Bfs Search
        while(!q.isEmpty()){
            Pair p = q.poll();
            Pair sp = null;
            if(p.i==i_end&&p.j==j_end){
                break;
            }
            for(String npkey:steps.keySet()){
                sp = steps.get(npkey);
                Pair np = new Pair(p.i+sp.i,p.j+sp.j);
                if(np.i>=0 && np.i<n && np.j>=0 && np.j<n && !history.containsKey(np.i+"-"+np.j)){
                    if(history.get(p.i+"-"+p.j).equals("")){
                        history.put(np.i+"-"+np.j,npkey);
                    }else{
                        history.put(np.i+"-"+np.j,history.get(p.i+"-"+p.j)+" "+npkey);
                    }
                    q.add(np);
                }    
            }
        }
        //Result output
        String end = history.get(i_end+"-"+j_end);
        String[] endhis = end.split(" ");
        System.out.println(endhis.length);
        for(String s:endhis){
            System.out.print(s+" ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}
class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}