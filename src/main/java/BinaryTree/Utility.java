package BinaryTree;
import org.springframework.stereotype.Component;

@Component
public class Utility {
    public String getRevString(String in_str) {
        String reverseStr ="";
        for(int i = in_str.length() - 1; i >=0 ;i--){
            reverseStr += in_str.charAt(i);
        }
        return reverseStr;
    }
    public long getCountChrOccurrence(String in_str,char c) {
        return (in_str.chars().filter(e->(char)e == c).count()) ;
    }
    public long getCountVowelOccurrence(String in_str) {
        return (in_str.chars().filter(e->(char)e == 'a' || (char)e == 'e' || (char)e == 'i' || (char)e == 'o' || (char)e == 'u').count()) ;
    }
}
