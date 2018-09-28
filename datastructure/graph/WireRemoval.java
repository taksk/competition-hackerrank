import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WireRemoval {
    static Map<Integer,Node> tree = new HashMap<Integer,Node>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int a0 = 0; a0 < n-1; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            //Add new node.
            Node xnode = tree.get(x);
            Node ynode=tree.get(y);
            if(xnode==null){
                xnode=new Node(x,y);
                tree.put(x,xnode);
            }else{
                xnode.children.add(y);
            } 
            if(ynode==null){
                ynode=new Node(y,x);
                tree.put(y,ynode);
            }else{
                ynode.children.add(x);
            }
        }
        
        countDesc(tree.get(1),0);
        //count descendants
        double result=0;
        double depsum=0;
        for(int key:tree.keySet()){
            //System.out.println("key:" + key+" descs:"+tree.get(key).descs+" depth:"+tree.get(key).depth);
            if(key==1)continue;
            Node nd=tree.get(key);
            result+=(n-nd.descs)*nd.depth;
            depsum+=nd.depth;
        }
        result/=depsum;
        System.out.println(result);        
        in.close();
    }
    
    static int countDesc(Node node,int depth){        
        node.depth=depth;
        node.visited=true;
        if(node.num!=1&&node.children.size()==1){
            node.descs=1;
            return 1;
        }
        int result=1;        
        for(int i:node.children){
            Node next = tree.get(i);
            if(!next.visited)result+=countDesc(next,depth+1);
        }
        node.descs=result;
        return node.descs;
    }
    
}

class Node{
    int num;
    int depth;
    int descs;
    boolean visited;
    ArrayList<Integer> children;
    Node(int num,int child){
        this.num=num;
        children=new ArrayList<Integer>();
        children.add(child);
        this.visited=false;
    }
}