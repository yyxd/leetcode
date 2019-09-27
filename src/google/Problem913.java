package google;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HinTi on 2019/9/23.
 * Goal:
 */

public class Problem913 {
    public int catMouseGame(int[][] graph) {
        int len = graph.length;
        int state[][] = new int[len][len];
        // state[i][j]: 0 平衡的点， 1 老鼠胜利，2 猫胜利
        int mouse = 1, cat = 2;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Pair<Integer, Integer> start = new Pair<>(mouse, cat);
        queue.offer(start);
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            mouse = cur.getKey();
            cat = cur.getValue();
            state[mouse][cat] = 1;
            List<Integer> mouseNext = new ArrayList<>();
            List<Integer> catNext = new ArrayList<>();
            // 当老鼠可以下一跳去往0时，这个点是
            for (int i = 0; i < graph[mouse].length; i++) {
                if (graph[mouse][i] == 0)
                    state[mouse][cat] = 1;
                if (graph[mouse][i] != cat)
                    mouseNext.add(graph[mouse][i]);
            }
            for (int i = 0; i < graph[cat].length; i++) {
                if (graph[cat][i] != 0)
                    catNext.add(graph[cat][i]);
            }
            if (mouseNext.size() == 0)
                state[mouse][cat] = -1;
            for (int i = 0; i < mouseNext.size(); i++) {
                for (int j = 0; j < catNext.size(); j++) {
                    int mn = mouseNext.get(i);
                    int cn = catNext.get(j);
                    if (state[mn][cn] == 0)
                        queue.offer(new Pair<>(mn, cn));
                }
            }

        }
        return -1;
    }
}