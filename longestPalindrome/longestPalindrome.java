package longestPalindrome;

public class longestPalindrome {
    /*
        Given a string s, return the longest palindromic substring in s.
     */

    public static void main(String[] args) {

    }

    public static String longestPalindrom(String s){

        if(s==null || s.length()==0)
            return "";
        int start=0, end=0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = isPalindrom(s, i, i);
            int len2 = isPalindrom(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len>end-start){
                start = i - (len-1)/2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end+1);
    }

    private static int isPalindrom(String s, int left, int right){
        int L=left, R=right;
        while(L>0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
