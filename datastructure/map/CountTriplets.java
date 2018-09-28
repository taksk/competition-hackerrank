import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//https://www.hackerrank.com/challenges/count-triplets-1
//Number is not always sorted. Counting number is not enough. Think about order of number.
//Use 2 maps. #1 has count of each number(l). #2 has count of multiplied numbers(l*r).
public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long result = 0;
        Map<Long,Long> map = new HashMap<Long,Long>();
        Map<Long,Long> rmap = new HashMap<Long,Long>();

       for(int i = arr.size()-1; i >= 0; i--){
            long l = arr.get(i);
            if(rmap.containsKey(l*r)){ //If l,l*r,l*r*r triplets exists.
                result += rmap.get(l*r);
            }
            if(map.containsKey(l*r)){
                long c = map.get(l*r);
                rmap.put(l, rmap.containsKey(l) ? rmap.get(l) + c : c );
            }
            map.put(l, map.containsKey(l) ? map.get(l)+1 : 1);
        } 
        
        return result;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./Input"))));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
