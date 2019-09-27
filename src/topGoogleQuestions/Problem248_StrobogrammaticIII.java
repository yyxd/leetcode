package topGoogleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HinTi on 2019/9/25.
 * Goal:
 */
public class Problem248_StrobogrammaticIII {
    public int strobogrammaticInRange(String low, String high) {
        int n = low.length();
        int m = high.length();
        if (m < n || (m==n&&high.compareTo(low) < 0)) return 0;
        int count = 0;
        for (int i = n + 1; i <= m; i++) {
            int k = i / 2;
            int tmp = 1;
            if ((i & 1) == 1) tmp *= 3;
            if (k >= 1)
                tmp = tmp * 4 * (int) Math.pow(5, k - 1);
            count += tmp;
        }
        System.out.println(count);
        List<String> lowRes = helper(n, n);
        List<String> highRes;
        if (n == m)
            highRes = lowRes;
        else
            highRes = helper(m, m);
        count = count + getCountGreaterThanTarget(lowRes, low) - getCountGreaterThanTarget(highRes, high);
        if (isStrobogrammatic(high))
            count++;
        return count;
    }

    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char lch = num.charAt(left);
            char rch = num.charAt(right);
            if (lch == rch) {
                if (lch != '1' && lch != '0' && lch != '8')
                    return false;
            } else {
                if (!(lch == '6' && rch == '9') && !(lch == '9' && rch == '6'))
                    return false;
            }
            left++;
            right--;
        }
        return true;
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("1", "0", "8"));
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }
        return res;
    }

    public int getCountGreaterThanTarget(List<String> stringList, String target) {
        int ans = 0;
        for (int i = 0; i < stringList.size(); i++) {
            String str = stringList.get(i);
            if (str.compareTo(target) >= 0)
                ans++;
        }
        return ans;
    }
}