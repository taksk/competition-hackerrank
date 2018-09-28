import java.util.*;

class Node implements Comparable<Node> {
    Node left;
    Node right;
    char data;
    int freq;
    String code;
    //Constructor
    Node(char data,int freq,Node left,Node right) {
        this.data = data;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(Node that){
        return (this.freq > that.freq ? 1 : (this.freq == that.freq ? 0 : -1));
    }
}

class HuffmanTree{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] cary=str.toCharArray();
        //Count characters.
        Map<Character,Integer> charcnt = new HashMap<Character,Integer>();
        for(char c:cary){
            if(charcnt.containsKey(c)){
                charcnt.put(c,charcnt.get(c)+1);
            }else{
                charcnt.put(c,1);
            }
        }
        //Sort entries by priority queue
        //When poll(), PriorityQueue always returns a entry which has smallest freq.(Same effect as sort)
        List<Map.Entry<Character,Integer>> entlist = new ArrayList<Map.Entry<Character,Integer>>(charcnt.entrySet());
        Queue<Node> nodeq = new PriorityQueue<Node>();
        for(Map.Entry<Character,Integer> ent:entlist){
           nodeq.add(new Node(ent.getKey(),ent.getValue(),null,null));
        }

        //Build huffman tree
        while(nodeq.size()>1){
            Node n1 = nodeq.poll();
            Node n2 = nodeq.poll();
            nodeq.add(new Node((char)-1,n1.freq+n2.freq,n1,n2));
        }
        Node root = nodeq.peek();

        //Dispatch code to characters.
        root.code="";
        dispatch(root);
    }
    
    
    static void dispatch(Node root){
        if(root.right==null&&root.left==null){
          System.out.println(root.data +":"+ root.code);
        }else{
            if(root.right!=null){
                root.right.code = root.code+"0";
                dispatch(root.right);
            }
            if(root.left!=null){
                root.left.code = root.code+"1";
                dispatch(root.left);
            }
        }
    }
}