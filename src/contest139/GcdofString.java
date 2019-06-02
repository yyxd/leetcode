package contest139;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-06-02.
 * Goal:
 */
public class GcdofString {
    public String gcdOfStrings(String str1, String str2) {
        String maxstr,minstr;
        if(str1.length()>str2.length()) {
            maxstr = str1;
            minstr = str2;
        }else {
            minstr = str1;
            maxstr = str2;
        }
        List<Integer> yz = yinzi(minstr.length());
        for(int i=yz.size()-1;i>=0;i--){
            String tempStr = minstr.substring(0,yz.get(i));
            if(issubStr(tempStr,minstr)&&issubStr(tempStr,maxstr))
               return tempStr;
        }
        return "";
    }

    public boolean issubStr(String shortStr,String s){
       int ss = shortStr.length();
       int len = s.length();
       if(len%ss!=0)
           return false;
        StringBuilder sb = new StringBuilder();
       for(int i =0;i<len/ss;i++){
           sb.append(shortStr);
       }
       return sb.toString().equals(s);
    }


    public List<Integer> yinzi(int len){
        List<Integer> ans = new ArrayList<>();
      int i = 1;
      while (i<=len){
          if(len%i==0){
              ans.add(i);
          }
          i++;
      }
      return ans;
    }



    public static void main(String[] args) {
        GcdofString gg = new GcdofString();
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gg.gcdOfStrings(str1,str2));
        System.out.println(gg.issubStr("AB",str1));
    }

    public String minString(String str){
        List<Integer> yz = yinzi(str.length());
        for(int y:yz){
            int len = str.length()/y;
            String tempStr = str.substring(0,y);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<len;i++){
                sb.append(tempStr);
            }
            if(sb.toString()==str)
                return tempStr;
        }
        return "";
    }
}
