package google.next.week4;

/**
 * Created by HinTi on 2019/7/24.
 * Goal:
 */
public class BackspaceCompare {
    public static boolean backspaceCompare(String S, String T) {
        String backS = getFinalString(S);
        String backT = getFinalString(T);
        return backS.equals(backT);

    }

    public static String getFinalString(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '#') {
                if(sb.length()>0) sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(getFinalString(s));
        System.out.println(getFinalString(t));
        System.out.println(s==t);

    }
}