package google_next;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Diane on 2019-07-23.
 * Goal:
 */
public class UseHashMap {
    public static String test(String str) {
        HashMap<Character, Integer> charTimes = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            charTimes.put(ch,charTimes.getOrDefault(ch, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        while (charTimes.size()>0) {
            Iterator<Map.Entry<Character, Integer>> iterator = charTimes.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                int v = entry.getValue();
                sb.append(entry.getKey());
                if (v == 1) {
                    iterator.remove();
                }else {
                    entry.setValue(v-1);
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(test("aabbccdd"));
        System.out.println(test("aaabbbccc"));
    }
}
