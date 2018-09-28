import java.io.*;
import java.util.*;

public class BotClean {
     
    public static void main(String[] args) {
        List<Pair> steps = new ArrayList<Pair>();
        steps.add(new Pair(-1,0));//UP
        steps.add(new Pair(0,1));//RIGHT
        steps.add(new Pair(1,0));//DOWN
        steps.add(new Pair(0,-1));//LEFT
        
        Scanner in = new Scanner(System.in);
        int bi=in.nextInt();
        int bj=in.nextInt();
        int di=-1;
        int dj=-1;
        char[][] grid=new char[5][5];
        boolean[][] visited=new boolean[5][5];
        for(int i = 0; i < 5; i++) grid[i] = in.next().toCharArray();
        
        if(grid[bi][bj]=='d'){
            System.out.println("CLEAN");
        }

        Queue<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(bi,bj));
        //Find nearest with bfs
        while(!q.isEmpty()){
            Pair p=q.poll();
            visited[p.i][p.j]=true;
            if(grid[p.i][p.j]=='d'){
                di=p.i;
                dj=p.j;
                break;
            }
            for(Pair st:steps){
                Pair np = new Pair(p.i+st.i,p.j+st.j);
                if(np.i>=0 && np.j>=0 && np.i<=4 && np.j<=4 && !visited[np.i][np.j]){
                    q.add(np);
                }                
            }
        }        
        
        //X move
        if(bj-dj>0){
            System.out.println("LEFT");
        }else if(bj-dj<0){
            System.out.println("RIGHT");
        }else{
            //Y move            
            if(bi-di>0){
                System.out.println("UP");
            }else if(bi-di<0){
                System.out.println("DOWN");
            }
        }
    }
    
    static class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}