package backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diane on 2019-06-30.
 * Goal:
 */
public class PermutationWithDuplicates {
    List<String> ans = new ArrayList<>();

    List<String> perm(String s) {
        StringBuilder a = new StringBuilder(s);
        perm(a, 0, a.length()-1);
        return ans;
    }

    void perm(StringBuilder a, int k, int m) {
        if (k == m) {
            String res = a.toString();
            ans.add(res);
        } else {
            for (int i = k ; i <= m; i++) {
                if (check(a, k, i)) {
                    swap(a, k, i);
                    perm(a, k + 1, m);
                    swap(a, k, i);
                }
            }
        }
    }

    void swap(StringBuilder a, int i, int j) {
        char c = a.charAt(i);
        a.setCharAt(i, a.charAt(j));
        a.setCharAt(j, c);
    }

    boolean check(StringBuilder a, int k, int i) {
        if (i > k) {// 排除i = k 允许自身交换
            for (int j = k; j < i; j++) {
                if (a.charAt(j) == a.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationWithDuplicates problem = new PermutationWithDuplicates();
        String s = "aabc";
        List<String> ans = problem.perm(s);
        ans.forEach(str-> System.out.println(str));
    }
}
