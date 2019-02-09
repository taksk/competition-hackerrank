public class Stream{
    //Sample code for Java streaming API
    public static void main(String[] args){
        String input = "sakashitatk";
        System.out.println(input.chars().filter(ch -> ch == 'a').count());    
    }
}