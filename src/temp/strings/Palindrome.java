package temp.strings;

import java.util.Stack;

/**
 * Created by HinTi on 2019/5/27.
 * Goal: 判断给定字符串，去除标点符号和空格外，忽略大小写后是不是回文串
 */
public class Palindrome {
    public static boolean isPalindrome(String s) {
//        Stack<Character> stack = new Stack<>();
        int i=0,j = s.length()-1;
        while (i<j){
            while (i<s.length()&&!isLegal(s.charAt(i)))
                i++;
            while (j>=0&&!isLegal(s.charAt(j)))
                j--;
            if(i==j||i>=s.length()||j<0) return true;
            if(isEqual(s.charAt(i),s.charAt(j))){
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }
    public static boolean isEqual(char c1,char c2){
        if('0'<=c1&&c1<='9')
            return c1==c2;
        return lower(c1)==lower(c2);
    }
    public static char lower(char c){
        if('A'<=c&&c<='Z')
            c = (char)(c-'A'+'a');
        return c;
    }
    public static boolean isLegal(char ch){
        if(('0'<=ch&&ch<='9')||('a'<=ch&&ch<='z')||('A'<=ch&&ch<='Z'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "a";
        String s1 = "a A a A";
        String s2 = "aaa";
        String s3 = "aa";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
    }
}
