package leetcode.strings;

/**
 * Created by Diane on 2019/2/8.
 * Goal:
 */
public class Problem344_ReverseString {
    public void reverseString(char[] s) {
        if(s.length <=1) return;
        int mid = s.length/2;
        for(int i=0;i<mid;i++){
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}
