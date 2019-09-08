package google.next.week4;

import java.util.*;

/**
 * Created by HinTi on 2019/7/23.
 * Goal:
 */
public class RearrangeString {
    public  String rearrange(String str, int k) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> charTimes = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charTimes.put(ch, charTimes.getOrDefault(ch, 0) + 1);
        }
        int max = str.length() / k;
        for (char key : charTimes.keySet()) {
            int value = charTimes.get(key);
            if (value > max) return "";
        }
        while (charTimes.size() > 0) {
            Iterator<Map.Entry<Character, Integer>> iterator = charTimes.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                ans.append(entry.getKey());
                int v = entry.getValue();
                if (v == 1)
                    iterator.remove();
                else
                    entry.setValue(v - 1);
            }
        }
        return ans.toString();
    }

    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        for (Integer i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);   //执行删除指定位置的元素的功能     执行结果　[11,12,13,14,15,16]
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);   //执行删除指定元素的功能          执行结果　[11,13,15]
            }
        }
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        String str1 = "aaabbbcccc";
//        System.out.println(rearrange(str1, 3));
    }
}