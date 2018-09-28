import java.util.Arrays;

//Confirm character code
//Code of 'a' is 97
//Code of '0' is 48
public class Charcode{
    public static void main(String[] args)  {
        boolean[] alpa = new boolean[26];
        boolean[] alpb = new boolean[26];
        System.out.println((int)'1');
        String inputa = "sakashitatk";
        String inputb = "abcde";
        int[] hoge = new int[26];
        inputa.chars().forEach(c -> alpa[(int)c -97] = true);//code of 'a' is 97
        inputb.chars().forEach(c -> alpb[(int)c -97] = true);
        for(int i=0; i<26; i++){
            if(alpa[i] && alpb[i]){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
    
        
        