package google.next.week4;

/**
 * Created by HinTi on 2019/7/24.
 * Goal:
 */
public class PermutedSubString {
    public boolean isPermutedSubString(String str1, String str2) {
        // 判断str2 是不是str1 的permuted 子串
        if (str2.length() > str1.length()) return false;
        int[] res = str2intVec(str2);
        int i = 0;
        while (i < (str1.length() - str2.length())) {
            int j = i;
            boolean flag = true;
            for (; j < i + str2.length(); j++) {
                int index = str1.charAt(i) - 'a';
                if (res[index] == 0) {
                    i = j + 1;
                    flag = false;
                    break;
                }
            }
            // 如果i-j种的字符都出现在str2中，判断子串与str2的桶排序是否一致
            if (flag) {
                boolean result = true;
                String tempStr = str1.substring(i, j);
                int[] temp = str2intVec(tempStr);
                for(int k=0;k<temp.length;k++){
                    if(res[k]!=temp[k]){
                        result = false;
                        break;
                    }
                }
                if(result) return true;
                else
                    i = i+1;
            }
        }
        return false;

    }

    /**
     * 对字符串进行桶排序
     *
     * @param str
     * @return
     */
    public int[] str2intVec(String str) {
        int[] charTimes = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            charTimes[index]++;
        }
        return charTimes;
    }
}