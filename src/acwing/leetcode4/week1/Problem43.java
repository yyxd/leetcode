package acwing.leetcode4.week1;

import java.util.Arrays;

/**
 * Created by HinTi on 2018/11/13.
 */
public class Problem43 {
    /**
     * 大数相乘，利用大数相加做，beats 6.2%
     * @param num1 大数1
     * @param num2 大数2
     * @return 相乘结果
     */
    public String multiply(String num1, String num2) {
        String ans = "";
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        //保证num1与num2中，s1是比较长的那条
        if(num1.length()<num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String postfix = "";
        ans = "0";
        for (int i = num2.length()-1; i >=0; i--) {
            if(num2.charAt(i)=='0')
            {
                postfix = postfix + "0";
                continue;
            }
            String result = num1;
            for(int j = 0;j<num2.charAt(i)-'1';j++)
                result = add(result,num1);
            result = result+postfix;
            ans = add(ans,result);
            postfix = postfix + "0";
        }
        return ans;
    }

    /**
     * 大数相乘，更快一点，直接相乘做
     * @param num1 大数1
     * @param num2 大数2
     * @return 相乘结果
     */
    public String multiplyFast(String num1, String num2){
        char[] chs1 = num1.toCharArray();
        char[] chs2  = num2.toCharArray();
        char[] results = new char[chs1.length+chs2.length];
        Arrays.fill(results,'0');
        for(int i = chs1.length-1;i>=0;i--)
        {
            int carry = 0;
            for(int j = chs2.length-1;j>=0;j--){
                int tmp = carry+(chs1[i]-'0')*(chs2[j]-'0')+results[i+j+1]-'0';
                results[i+j+1] = (char)(tmp%10+'0');
                carry = tmp/10;
            }
            results[i] +=carry;
        }
        int start = 0;
        while (start<results.length-1&&results[start] == '0') start++;
        return new String(results).substring(start);
    }
    /**
     * 大数相加
     * @param s1 大数1
     * @param s2 大数2
     * @return 相加结果
     */
    public String add(String s1, String s2) {
        //保证s1与s2中，s1是比较长的那条
        if(s1.length()<s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        if(s2.equals("0")) return s1;
        int flag = 0;
        String ans = "";
        for (int i = s2.length()-1; i >=0; i--) {
            char lasts1 = s1.charAt(i+s1.length()-s2.length());
            char lasts2 = s2.charAt(i);
            int res =   lasts1+lasts2 -'0'-'0'+ flag;
            flag = res / 10;
            ans = String.valueOf(res%10)+ans;
        }
        for(int i = s1.length()-s2.length()-1;i>=0;i--){
            int res = s1.charAt(i) - '0' + flag;
            flag = res / 10;
            ans = String.valueOf(res%10)+ans;
        }
        if(flag >0)
            ans = flag+ans;
        return ans;
    }


    public static void main(String[] args) {
        Problem43 problem43 = new Problem43();
        System.out.println(problem43.multiply("3","5"));
        System.out.println(problem43.multiplyFast("3","5"));
        String s1 = "9",s2 = "99";
        System.out.println(problem43.multiply(s1,s2));
        System.out.println(problem43.multiplyFast(s1,s2));
        s1 ="123"; s2 = "456";
        System.out.println(problem43.multiply(s1,s2));
        System.out.println(problem43.multiplyFast(s1,s2));
        s1 ="761"; s2 = "40";
        System.out.println(problem43.multiply(s1,s2));
        System.out.println(problem43.multiplyFast(s1,s2));
    }
}
