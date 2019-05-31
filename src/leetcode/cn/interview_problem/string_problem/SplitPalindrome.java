package leetcode.cn.interview_problem.string_problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-05-27.
 * Goal: 分割回文串，回溯！全排列！
 */
public class SplitPalindrome {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if (s.length()<=0) return ans;
        List<String> list = new ArrayList<>();
        find(list,s,0);
        return ans;

    }

    /**
     * 查找将字符串按照回文串进行分割的方案
     * @param list 保存的已经分割的回文串的列表
     * @param s 字符串
     * @param index 字符串开始搜索回文串的位置
     */
    public void find(List<String> list,String s, int index){
        if(index==s.length()) ans.add(new ArrayList<>(list));
        int i = index;
        while (i<s.length()){
            if(isPalin(s,index,i)){
                list.add(s.substring(index,i+1));
                find(list,s,i+1);
                list.remove(list.size()-1);// 回溯，回复状态
            }
            i++;
        }

    }

    /**
     * 判断 string从位置 i 到 j 的子串是否是回文串
     * @param s
     * @param i
     * @param j
     * @return
     */
    public boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SplitPalindrome sp = new SplitPalindrome();
        List<List<String>> res = sp.partition("aabbccbbaa");
        for(int i=0;i<res.size();i++){
            List<String> list = res.get(i);
            for(String s :list){
                System.out.print(s+"\t");
            }
            System.out.println();
        }

    }
}
