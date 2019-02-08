package leetcode.strings;

/**
 * Created by Diane on 2019/2/8.
 * Goal:
 */
public class Problem151_ReverseWordsInString {
    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i=strs.length-1;i>=0;i--){
            strs[i] = strs[i].trim();
            if(strs[i].length()!=0) {
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        while(sb.length()>0&&sb.charAt(sb.length()-1)==' ')
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
        String s1 = "   1";
        System.out.println(reverseWords(s1)+"huangdan");
        String s2 = "1 ";
        System.out.println("hello"+reverseWords(s2));
        String s3 = "  a   b ";
        System.out.println("hello"+reverseWords(s3));
    }
}
