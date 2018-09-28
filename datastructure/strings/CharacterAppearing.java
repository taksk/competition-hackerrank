import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string
//Think about all YES pattern.
public class CharacterAppearanceCount {

    // Complete the isValid function below.
    static String isValid(String s) {
        int[] ccnt = new int[26];
        s.chars().forEach(c -> ccnt[(int)c -97] ++);        
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        Arrays.stream(ccnt).forEach(i -> m.put(i, m.containsKey(i) ? m.get(i) + 1 : 1));
        m.remove(0);
        //Evaluate appearance count
        Set<Integer> ks = m.keySet();
        if(ks.size() == 1){//All appearance counts are same.
            return "YES";
        }else if(ks.size() == 2){//Two patterns.
            Integer[] i = ks.toArray(new Integer[2]);
            int ccnt1 = m.get(i[0]);//Number of character count
            int ccnt2 = m.get(i[1]);//Number of character count
            if(Math.abs(i[0] - i[1]) == 1){//Exceptional character appears 1 more time
                if(ccnt1 == 1 || ccnt2 == 1){
                    return "YES";    
                }
            }else{//Exceptional character appears only 1 time
                if((i[0] == 1 && ccnt1 == 1) ||(i[1] == 1 && ccnt2 == 1)){
                    return "YES";
                }
            }
        }
        return "NO";      
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
