package contest.contest155;

import java.util.*;

/**
 * Created by Diane on 2019-09-22.
 * Goal:
 */
public class ProblemC {
    int[] parents;

    public void init() {
        for (int i = 0; i < parents.length; i++)
            parents[i] = i;
    }

    public int find(int i) {
        if (parents[i] == i)
            return i;
        else {
            parents[i] = find(parents[i]);
            return parents[i];
        }
    }

    public boolean merge(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return false;
        parents[px] = py;
        return true;
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        parents = new int[s.length()];
        init();
        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            merge(x, y);
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int pi = find(i);
            if (map.containsKey(pi))
                map.get(pi).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(pi, list);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> sIndex = entry.getValue();
            char[] chs = new char[sIndex.size()];
            for (int i = 0; i < sIndex.size(); i++) {
                int index = sIndex.get(i);
                char ch = s.charAt(index);
                chs[i] = ch;
            }
            Arrays.sort(chs);
            for (int i = 0; i < sIndex.size(); i++) {
                int index = sIndex.get(i);
                stringBuilder.setCharAt(index, chs[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ProblemC problemC = new ProblemC();
        List<Integer> pair = new ArrayList<>();
    }
}
