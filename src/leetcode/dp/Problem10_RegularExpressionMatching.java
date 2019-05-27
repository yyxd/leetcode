package leetcode.dp;

/**
 * Created by Diane on 2019-04-27.
 * Goal: 正则表达式匹配，处理.和*
 * Solution: A: 使用递归解决问题
 */
public class Problem10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,0,0);
    }

    public boolean isMatch(String s,String p,int ss,int ps){
        if(ps>p.length()||ss>s.length()) return false;
        if(ss==s.length()&&ps==p.length()) return true;
        if(ps==p.length()) return false;
        if(ss==s.length())
            return ps+1<p.length()&&p.charAt(ps+1)=='*'&&isMatch(s,p,ss,ps+2);
        if(ps+1<p.length()&&p.charAt(ps+1)=='*')
            return isMatch(s,p,ss,ps+2)||(p.charAt(ps)=='.'||(s.charAt(ss)== p.charAt(ps))&&isMatch(s, p, ss + 1, ps));
        else if(p.charAt(ps)=='.'||s.charAt(ss)== p.charAt(ps))
            return isMatch(s,p,ss+1,ps+1);
        else
            return false;
    }

}
