import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/journey-to-the-moon/problem
//combinations of different group = All combinations - combinations from same group
public class DfsPairs {

    static boolean[] visited;
    static Graph g;
    static long journeyToMoon(int n, int[][] astronaut) {
        // Complete this function
        long result =0;
        visited = new boolean[n];
        g=new Graph(n,false);
        int[] gcnt=new int[n];
        
        long start=Calendar.getInstance().getTimeInMillis();
        for(int[] pair:astronaut){
            g.addEdge(pair[0],pair[1]);                
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                gcnt[i]=nextNode(i);
            }
        }

        result =(long)n*(n-1)/2;
        for(int i=0;i<gcnt.length;i++){
            if(gcnt[i]<=1)continue;
            result-=gcnt[i]*(gcnt[i]-1)/2;
        }
        
        return result;
    }
    
    static int nextNode(int node){
        int result=1;
        visited[node]=true;
        for(int next:g.edges[node]){
            if(!visited[next]){
                result+=nextNode(next);
            }
        }
        return result;
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[][] astronaut = new int[p][2];
        for(int astronaut_i = 0; astronaut_i < p; astronaut_i++){
            for(int astronaut_j = 0; astronaut_j < 2; astronaut_j++){
                astronaut[astronaut_i][astronaut_j] = in.nextInt();
            }
        }
        long result = journeyToMoon(n, astronaut);
        System.out.println(result);
        in.close();
    }
}

class Graph{
    int nodeNum;
    private final boolean directed;
    ArrayList<Integer>[] edges;    
    
    Graph(int nodeNum,boolean directed){
        this.nodeNum = nodeNum;
        this.directed = directed;
        this.edges = new ArrayList[nodeNum + 1];
        for(int i = 0;i<nodeNum + 1;i++){
            edges[i] = new ArrayList<Integer>();
        }
    }    
    public void addEdge(int node1,int node2){
        edges[node1].add(node2);
        if(!this.directed){
            edges[node2].add(node1);
        }
    }
}
