package lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    /*
        Given a string s, find the length of the
         longest substring without repeating characters.
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("BBBB"));
        System.out.println(lengthOfSubstring2(""));
    }

    public static int lengthOfLongestSubstring(String s){
        int len = 0;
        if(s.length()==1)
            return 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(noRepeat(s, i, j))
                    len = len>(j-i)? len:j-i+1;
                else {
                    len=1;
                }
            }
        }
        return len;
    }

    public static boolean noRepeat(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            Character ch = s.charAt(i);
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    public static int lengthOfSubstring2(String s){
        int n = s.length();
        int len = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                len = len>(j-i)?len:j-i;
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return len;
    }
}
