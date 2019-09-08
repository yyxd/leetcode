package contest.contest143;

/**
 * Created by HinTi on 2019/6/30.
 * Goal:
 */
public class Problem4 {
    public boolean parseBoolExpr(String expression) {
        char c = expression.charAt(0);
        if (c == '!')
            return !parseBoolExpr(expression.substring(2, expression.length() - 1));
        else if (c == '|')
            return _parseBoolExprOr(expression.substring(2, expression.length() - 1));
        else if (c == '&')
            return _parseBoolExprAnd(expression.substring(2, expression.length() - 1));
        else
            return c == 't';
    }

    public boolean _parseBoolExprOr(String expression) {
        boolean b = false;
        int len = expression.length(), bracket = 0, i = 0;
        char c;
        for (int j = 0; j < len && !b; j++) {
            c = expression.charAt(j);
            if (c == '(') {
                bracket++;
            } else if (c == ')') {
                bracket--;
            } else if (bracket == 0 && c == ',') {
                b = parseBoolExpr(expression.substring(i, j));
                i = j + 1;
            }
        }
        if (i != len) b |= parseBoolExpr(expression.substring(i, len));
        return b;
    }

    public boolean _parseBoolExprAnd(String expression) {
        boolean b = true;
        int len = expression.length(), bracket = 0, i = 0;
        char c;
        for (int j = 0; j < len && b; j++) {
            c = expression.charAt(j);
            if (c == '(') {
                bracket++;
            } else if (c == ')') {
                bracket--;
            } else if (bracket == 0 && c == ',') {
                b = parseBoolExpr(expression.substring(i, j));
                i = j + 1;
            }
        }
        if (i != len) b &= parseBoolExpr(expression.substring(i, len));
        return b;
    }

}