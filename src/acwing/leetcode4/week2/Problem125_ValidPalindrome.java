package acwing.leetcode4.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HinTi on 2018/11/28.
 * Goal:
 */
public class Problem125_ValidPalindrome {
    public boolean isPalindrome (String s)
    {
        if (s == "")
            return false;
        s = transform(s);
        int i = 0,j = s.length()-1;
        while (i<j){
            if(s.charAt(i)==s.charAt(j)) {
                i++;
                j--;
            }else
                return false;
        }
        return true;
    }

    public String transform(String s)
    {
        List<Character> characters = new ArrayList<>();
        for(int i =0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if (('a'<=c&&c<='z')||('A'<=c&&c<='Z')||('0'<=c&&c<='9')){
                if('A'<=c&&c<='Z')
                    c =(char)(c-'A'+'a');
                characters.add(c);
            }
        }
        StringBuilder str = new StringBuilder();
        for(Character ch:characters)
            str.append(ch);
       // System.out.println(str.toString());
        return str.toString();
    }

    public static void main(String[] args) {
        Problem125_ValidPalindrome validPalindrome = new Problem125_ValidPalindrome();
        String str = "0P";
        System.out.println(validPalindrome.isPalindrome(str));
    }
}
