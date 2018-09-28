import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//https://www.hackerrank.com/contests/world-codesprint-12/challenges/factorial-array
//40! is divisible by 10^9
//Use segment tree to reduce operation number.
public class FactorialArray {
	static final int MAX=40;
	static class Node{
		int lazy=0;
		int[] cnts= new int[MAX+1];
	}
	private static int n=0;
	private static int[] A=null;
	private static Node[] segTree=null;
	private static int mod=1000000000;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		A = new int[n];
		for(int A_i = 0; A_i < n; A_i++){
			A[A_i]=Math.min(MAX,in.nextInt());
		}
		long[] factorials = new long[MAX+1];
		factorials[1]=1;
		for(int i=2;i<=MAX;i++){
			factorials[i]=factorials[i-1]*i % mod;
		}
		
		buildTree();

		for(int a0 = 0; a0 < m; a0++){
			// Write Your Code Here
			int o = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			switch(o){
			case 1:
				update(1,0,n-1,l-1,r-1,1);
				break;
			case 2:				
				long result = 0L;
				int[] cnts=rangeSum(1, 0, n-1, l-1, r-1);
				for(int i=1;i<MAX;i++){//i=MAX is not required.                    
					result=(result+factorials[i]*cnts[i])%mod;
				}					
				System.out.println(result);				
				break;
			case 3://Command 3 is not addition operation. So you need to calculate delta.
				int[] localCnt = rangeSum(1, 0, n-1, l-1, l-1);
				int oldVal=0;
				for(int i=1;i<=MAX;i++){
					if(localCnt[i]!=0){
						oldVal=i;
					}
				}
				if(r>MAX)r=MAX;
				if(oldVal!=r)update(1,0,n-1,l-1,l-1,r-oldVal);					
			}
		}
		in.close();
	}

	private static int[] rangeSum(int node,int lo,int hi,int fr,int to){
		int[] tot=new int[MAX+1];
		//This node is out of target range, So return 0 array.
		if(to<lo||fr>hi||lo>hi){
			return tot;
		}else{
			propagate(node, lo, hi);
			if(fr<=lo&&hi<=to){//This node is inclose in target.
				return segTree[node].cnts;
			}else{//Not inclose gather children counts and sum up.
				int mid=(lo+hi)/2;
				int[] left=rangeSum(node*2,lo,mid,fr,to);
				int[] right=rangeSum(node*2+1,mid+1,hi,fr,to);
				for(int i=1;i<=MAX;i++){
					tot[i]=left[i]+right[i];
				}
				return tot;
			}
		}	
	}

	private static void update(int node,int lo,int hi,int fr,int to,int delta){
		if(lo>hi){
			return;
		}else if(to<lo||fr>hi){
			propagate(node,lo,hi);
			return;
		}else if(fr<=lo&&hi<=to){//Target range is inclosed in lo hi.
			segTree[node].lazy+=delta;
			propagate(node,lo,hi);
			return;
		}else{//Target range is wider than lo hi.
			propagate(node,lo,hi);
			int mid=(lo+hi)/2;
			update(node*2,lo,mid,fr,to,delta);
			update(node*2+1,mid+1,hi,fr,to,delta);
			//Gathering counts in children
			for(int i=1;i<=MAX;i++){
				segTree[node].cnts[i]= segTree[node*2].cnts[i] + segTree[node*2+1].cnts[i];
			}
		}
	}
    
	private static void propagate(int node,int lo,int hi){
		int lazy=segTree[node].lazy;
		segTree[node].lazy=0;
		if(lazy==0)return;

		if(lo==hi){
			int oldVal=A[lo];
			int newVal=Math.min(A[lo]+lazy, MAX);
			segTree[node].cnts[oldVal]=0;
			segTree[node].cnts[newVal]=1;
			A[lo]=newVal;			
		}else{
			int[] tmp=new int[MAX+1];
			for(int i=1;i<=MAX;i++){
				tmp[i]=segTree[node].cnts[i];
				segTree[node].cnts[i]=0;
			}
			for(int i=1;i<=MAX;i++){
				segTree[node].cnts[Math.min(MAX, i+lazy)]=tmp[i];//Ignore case i+lazy>40.
			}
			segTree[node*2].lazy+=lazy;
			segTree[node*2+1].lazy+=lazy;
		}
	}

	private static void buildTree(){
		segTree=new Node[4*n];
		build(1,0,n-1);
	}
	private static void build(int node,int lo,int hi) {
		if(lo>hi)return;    		
		segTree[node]=new Node();
		if(lo==hi){//In leaf node,set cnts and exit.
			segTree[node].cnts[A[lo]]=1;
			return;
		}
		//Not leaf, break down to branch nodes.
		int mid=(lo+hi)/2;
		build(node*2, lo, mid);
		build(node*2+1, mid+1, hi);
		//Gather counts of children nodes;
		for(int i=0;i<=MAX;i++){
			segTree[node].cnts[i]=segTree[node*2].cnts[i] + segTree[node*2+1].cnts[i];
		}
	}
}
