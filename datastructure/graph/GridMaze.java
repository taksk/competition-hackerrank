import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Direction{
    int x;
    int y;
    Direction(int x,int y){
        this.x=x;
        this.y=y;
    }
}

//https://www.hackerrank.com/challenges/castle-on-the-grid/
//Think given grid as graph.Use BFS.
public class GridMaze {
    
    static List<Direction> directions = new ArrayList<Direction>();
    static String[] grid;
    static int n;
    static int[][] steps;
    static int goalX;
    static int goalY;
    
    static void printSteps(){
        for(int[] row:steps){
            for(int i:row){
                System.out.print(i + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Complete the minimumMoves function below.
    static int minimumMoves(String[] ingrid, int startX, int startY, int ingoalX, int ingoalY) {
        grid = ingrid;
        n = grid.length;
        goalX = ingoalX;
        goalY = ingoalY;
        
        directions.add(new Direction(-1,0));//up
        directions.add(new Direction(0,1));//right
        directions.add(new Direction(1,0));//down
        directions.add(new Direction(0,-1));//left
    
        steps = new int[grid.length][grid.length];

        for(int i = 0; i < n; i++){
            char[] ca = grid[i].toCharArray();
            for(int j = 0; j < n; j++){
                steps[i][j] = ca[j] != 'X' ? Integer.MAX_VALUE : -1;
            }
        }
        
        steps[startX][startY] = 1;
        
        for(int ndid=0; ndid < 4; ndid++){
            Direction nextd = directions.get(ndid);
            int nextx = startX + nextd.x;
            int nexty = startY + nextd.y;
            int newstep = 1;
            if(nexty >= 0 && nexty < n && nextx >= 0 && nextx < n && newstep < steps[nextx][nexty] && grid[nextx].charAt(nexty) != 'X'){
                rec(newstep,startX,startY,ndid);
            }  
        }
        printSteps();
        return steps[goalX][goalY];
    }
    
    static void rec(int step, int cx, int cy, int direction){
        int dx = directions.get(direction).x;
        int dy = directions.get(direction).y;
        while(cy + dy >= 0 && cy + dy <= n-1 && cx + dx >= 0 && cx + dx <= n-1){
           cx += dx;
           cy += dy;
           if(grid[cx].charAt(cy) == 'X'){
               break;
           }else{
               if(step < steps[cx][cy]){
                    steps[cx][cy] = step;
                    for(int ndid=0; ndid < 4; ndid++){
                        if(direction % 2 == ndid % 2)continue;//Don't search same axis.
                        Direction nextd = directions.get(ndid);
                        int nextx = cx + nextd.x;
                        int nexty = cy + nextd.y;
                        int newstep = step + 1;
                        if(nexty >= 0 && nexty < n && nextx >= 0 && nextx < n && newstep < steps[nextx][nexty] && grid[nextx].charAt(nexty) != 'X'){
                            rec(newstep,cx,cy,ndid);
                        }  
                    }
                }
            }                
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
