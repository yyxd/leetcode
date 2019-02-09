package leetcode.strings;

/**
 * Created by Diane on 2019/2/8.
 * Goal: 将字符串转化为整数,自己不懂得地方在于如何将大于INT.MAX 的值转化为 INT.MAX,将INT.MIN的值化为 INT.MIN
 * 自己想到的解法是用更高精度的long来保存
 */
public class Problem8_atoi {
    public static int myAtoi(String str) {
        str = str.trim();
        if(str.charAt(0)=='-'||str.charAt(0)=='+'||'0'<=str.charAt(0)&&str.charAt(0)<='9'){
            return trans(str);
        }else {
            return 0;
        }
    }

    public static int trans(String str){
        long ans = 0;
        boolean flag = true;
        int i = 0;
        if(str.charAt(0)=='-'){
            flag = false;
            i++;
        }if(str.charAt(0)=='+'){
            i++;
        }
        for(;i<str.length();i++){
           if('0'<=str.charAt(i)&&str.charAt(i) <='9')
            ans = ans*10+str.charAt(i)-'0';
           else break;
        }
        ans =  flag?ans:-1*ans;
       // if(ans<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
       // if(ans>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return new Long(ans).intValue();
    }

    public static void main(String[] args) {

    }
}
