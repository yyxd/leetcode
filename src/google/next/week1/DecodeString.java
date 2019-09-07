package google.next.week1;

/**
 * Created by HinTi on 2019/7/12.
 * Goal:
 */
public class DecodeString {
    public static String decodeString(String s) {
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i<s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int k = 0;
                int bracket = 0;
                while (Character.isDigit(s.charAt(i))) {
                    k = k * 10 + s.charAt(i) - '0';
                    i++;
                }
                int start = i;
                bracket++;
                i++;
                while (i<s.length()&&bracket > 0) {
                    if (s.charAt(i) == '[')
                        bracket++;
                    else if (s.charAt(i) == ']')
                        bracket--;
                    i++;
                }
                int end = i;
                String sub = decodeString(s.substring(start + 1, end - 1));
                for (int j = 0; j < k; j++)
                    builder.append(sub);
            }else {
                builder.append(s.charAt(i));
                i++;
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
}