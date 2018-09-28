import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/crossword-puzzle/problem
//.clone() deep-copy Object of Array, But don't deep-copy material in Array.
class Space{
    int x = -1;
    int y = -1;
    int len = -1;
    char vh = 'x';
    public String toString(){
        return "x:" + x + " y:" + y + " len:" + len + " vh:" + vh;
    }
}

public class Crossword {
    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        char[][] cwa = new char[10][10];
        for(int i = 0; i < 10; i++){
            cwa[i] = crossword[i].toCharArray();
        }
        String[] wary = words.split(";");
        List<String> wlist = new ArrayList<String>();
        Arrays.stream(wary).forEach(w -> wlist.add(w));
        
        List<Space> splist = new ArrayList<Space>();
        
        //Find horizontal space
        for(int i = 0; i < 10; i++){
            boolean inhs = false;
            int len = 0;
            Space sp = null;
            for(int j = 0; j < 10; j++){
                if(cwa[i][j] == '-'){
                    if(j < 9 && cwa[i][j+1] =='-'){
                        if(inhs){
                            sp.len++;
                        }else{
                            sp = new Space();
                            sp.x = j;
                            sp.y = i;
                            sp.len = 2;
                            sp.vh = 'h';
                            inhs = true;
                        }
                    }else{
                        if(inhs){                            
                            splist.add(sp);                            
                            inhs = false;
                        }else{
                            continue;
                        }
                        
                    }
                }
            }
        }
        
        //Find vertical space
        for(int j = 0; j < 10; j++){
            boolean inhs = false;
            int len = 0;
            Space sp = null;
            for(int i = 0; i < 10; i++){
                if(cwa[i][j] == '-'){
                    if(i < 9 && cwa[i+1][j] == '-'){
                        if(inhs){
                            sp.len++;
                        }else{
                            sp = new Space();
                            sp.x = j;
                            sp.y = i;
                            sp.len = 2;
                            sp.vh = 'v';
                            inhs = true;
                        }
                    }else{
                        if(inhs){                            
                            splist.add(sp);                            
                            inhs = false;
                        }else{
                            continue;
                        }
                        
                    }
                }
            }
        }
        String[] result = new String[10];
        char[][] resca = solve(wlist,splist,cwa);
        for(int i = 0; i < 10; i++){
            result[i] = new String(resca[i]);
        }
        return result;
    }
    
    static char[][] solve(List<String> wlist, List<Space> splist,char[][] cwa){
        if(splist.size() == 0 && wlist.size() == 0)return cwa;
        Space s = splist.get(0);
        char[][] result = null;
        for(String word : wlist){
            if(isAcceptable(cwa,s,word)){
                //Copy array for next phase.
                char[][] newcwa = new char[10][10];
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        newcwa[i][j] = cwa[i][j];
                    }  
                }
                newcwa = apply(newcwa,s,word);
                List<Space> newsplist = new ArrayList<Space>(splist);
                newsplist.remove(0);
                List<String> newwlist = new ArrayList<String>(wlist);
                newwlist.remove(word);
                newcwa = solve(newwlist,newsplist,newcwa);
                result = newcwa != null ? newcwa : result;
            }else{
                //System.out.println("Not applied!");
                continue;
            }
        }
        //System.out.println("result..." + result);
        return result;
    }
    
    static boolean isAcceptable(char[][] cwa, Space s, String word){
       if(word.length() != s.len)return false;
       if(s.vh == 'v'){
           for(int i = 0; i < s.len; i++){
                if(cwa[s.y + i][s.x] == '-' || cwa[s.y + i][s.x] == word.charAt(i)){
                    continue;
                }else{
                    return false;
                }
           }
       }else{
           for(int i = 0; i < s.len; i++){
                if(cwa[s.y][s.x + i] == '-' || cwa[s.y][s.x + i] == word.charAt(i)){
                    continue;
                }else{
                    return false;
                }
            }
       }
       return true;
    }
    
    static char[][] apply(char[][] cwa, Space s, String word){
      if(s.vh == 'v'){
           for(int i = 0; i < s.len; i++){
                cwa[s.y + i][s.x] = word.charAt(i);
           }
       }else{
           for(int i = 0; i < s.len; i++){
                cwa[s.y][s.x + i] =  word.charAt(i);
            }
       }
       return cwa;
    }
    
    static void printGrid(char[][] cwa){
        System.out.println(cwa);
        for(char[] row: cwa){
            for(char c:row){
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++) {
            String crosswordItem = scanner.nextLine();
            crossword[i] = crosswordItem;
        }

        String words = scanner.nextLine();

        String[] result = crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
