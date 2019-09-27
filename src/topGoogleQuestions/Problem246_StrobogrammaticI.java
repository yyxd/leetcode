package topGoogleQuestions;

/**
 * Created by HinTi on 2019/9/25.
 * Goal:
 */
public class Problem246_StrobogrammaticI {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char lch = num.charAt(left);
            char rch = num.charAt(right);
            if (lch == rch) {
                if (lch != '1' && lch != '0' && lch != '8')
                    return false;
            } else {
                if (!(lch == '6' && rch == '9') && !(lch == '9' && rch == '6'))
                    return false;
            }
            left++;
            right--;
        }
        return true;
    }
}