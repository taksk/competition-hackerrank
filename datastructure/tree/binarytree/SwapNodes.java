import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/swap-nodes-algo/problem
public class SwapNodes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node[] nodes = new Node[n];
        for(int i=0;i<n;i++)nodes[i]=new Node();

        //Build tree
        for(int i=0;i<n;i++){
            nodes[i].index = i+1;
            int left=scan.nextInt();
            int right=scan.nextInt();
            if(left!=-1)nodes[i].left=nodes[left-1];
            if(right!=-1)nodes[i].right=nodes[right-1];
        }

        int t=scan.nextInt();
        for(int j=0;j<t;j++){
            int k=scan.nextInt();
            swap(nodes[0],0,k);
            inorderTraversal(nodes[0]);
            System.out.println();
        }
    }
    
    static void swap(Node node,int depth,int k){
        depth++;
        if(depth%k==0){
            Node tmp=node.left;
            node.left=node.right;
            node.right=tmp;
        }
        if(node.left!=null)swap(node.left,depth,k);
        if(node.right!=null)swap(node.right,depth,k);
    }

    static void inorderTraversal(Node node){
        if(node.left!=null)inorderTraversal(node.left);
        System.out.print(node.index + " ");
        if(node.right!=null)inorderTraversal(node.right);
    }
}

class Node {
    Node left;
    Node right;
    int index;
}