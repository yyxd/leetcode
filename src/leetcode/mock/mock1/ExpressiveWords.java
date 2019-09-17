package leetcode.mock.mock1;

/**
 * Created by Diane on 2019-09-10.
 * Goal:
 */
public class ExpressiveWords {
    public static int expressiveWords(String S, String[] words) {
        int ans = 0;
        for (String w : words)
            if (isExtends(S, w))
                ans++;
        return ans;
    }

    public static boolean isExtends(String S, String mini) {
        int i = 0, j = 0;
        if (mini.length() > S.length())
            return false;
        Character pre = null;
        int size = 0;
        while (i < mini.length() || j < S.length()) {
            if (i < mini.length() && mini.charAt(i) == S.charAt(j)) {
                if (size != 0 && size < 2) return false;
                pre = mini.charAt(i);
                i++;
                j++;
                size = 0;
            } else {
                if (pre == null) return false;
                if (pre == S.charAt(j)) {
                    j++;
                    size++;
                } else {
                    return false;
                }
            }
        }
        return (size == 0 || size >= 2) && i == mini.length() && j == S.length();
    }

    public static void main(String[] args) {
        String[] words = {"hello", "hi", "helo"};
        String S = "heeellooo";
        String S2 = "dddiiiinnssssssoooo";
        String[] words2 = {"dinnssoo", "ddinso", "ddiinnso",
                "ddiinnssoo", "ddiinso", "dinsoo",
                "ddiinsso", "dinssoo", "dinso"};
        System.out.println(expressiveWords(S, words));
    }
}
