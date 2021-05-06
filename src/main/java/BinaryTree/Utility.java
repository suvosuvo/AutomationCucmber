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
}
