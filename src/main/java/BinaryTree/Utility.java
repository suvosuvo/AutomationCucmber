package BinaryTree;
import io.cucumber.java.bs.I;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class Utility {
    public String getRevString(String in_str) {
        String reverseStr = "";
        for (int i = in_str.length() - 1; i >= 0; i--) {
            reverseStr += in_str.charAt(i);
        }
        return reverseStr;
    }

    public long getCountChrOccurrence(String in_str, char c) {
        return (in_str.chars().filter(e -> (char) e == c).count());
    }

    public long getCountVowelOccurrence(String in_str) {
        return (in_str.chars().filter(e -> (char) e == 'a' || (char) e == 'e' || (char) e == 'i' || (char) e == 'o' || (char) e == 'u').count());
    }

    public String getDuplicateDelete(String in_str) {
        return Arrays.stream(in_str.split(" ")).distinct().collect(Collectors.joining(" "));
    }

    public String getDataFormat(String in_str) {
        ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList("th JAN ","th FEB ","th MAR ",
                "th APR ","th MAY ","th JUN ","th JUL ","th AUG ","th SEP ","th OCT ","th NOV ","th DEC "));
        in_str = in_str.substring(0, 2) +
                arrayList.get(Integer.parseInt(in_str.substring(2, 4)) - 1)+
                in_str.substring(4, in_str.length());
        return in_str;
    }
//    public HashMap<Character, Integer> getCountElement(Object in_str) {
//        String str1 = "aaabcccdeeef";
//        String str2 = "abcbad";
//        String str3 = "abcabcabc";
//        HashMap<Character, Integer> char_count = new HashMap<>();
//        for(int i= 0; i<=str1.length() ;i++)
//        {
//            if(char_count.containsKey(str1.charAt(i))){
//                char_count.put(str1.charAt(i),char_count.get(str1.charAt(i)+1));
//            }
//            else
//            {
//                char_count.put(str1.charAt(i),1);
//            }
//
//        }
//        for(int i=0;i<str1.length();i++){
//            if( str1.charAt(i) == 1)
//                return str1.charAt(i);
//        }
//
//    }
}
