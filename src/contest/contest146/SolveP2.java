package contest.contest146;

import java.util.*;

/**
 * Created by Diane on 2019-07-21.
 * Goal:
 */
public class SolveP2 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Arrays.sort(red_edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                if (edge1[0] != edge2[0])
                    return edge1[0] - edge2[0];
                else
                    return edge1[1] - edge2[1];
            }
        });
        Arrays.sort(blue_edges, new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                if (edge1[0] != edge2[0])
                    return edge1[0] - edge2[0];
                else
                    return edge1[1] - edge2[1];
            }
        });
        Map<Integer, List<Integer>> mapRed = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> mapBlue = new HashMap<Integer, List<Integer>>();
        for (int[] red_edge : red_edges) {
            int src = red_edge[0], dst = red_edge[1];
            List<Integer> list = mapRed.getOrDefault(src, new ArrayList<Integer>());
            if (!list.contains(dst))
                list.add(dst);
            mapRed.put(src, list);
        }
        for (int[] blue_edge : blue_edges) {
            int src = blue_edge[0], dst = blue_edge[1];
            List<Integer> list = mapBlue.getOrDefault(src, new ArrayList<Integer>());
            if (!list.contains(dst))
                list.add(dst);
            mapBlue.put(src, list);
        }
        final int WHITE = 0;
        final int GRAY = 1;
        final int BLACK = 2;
        final int RED = 3;
        final int BLUE = 4;
        int[][] colorsRed = new int[n][2];
        int[][] colorsBlue = new int[n][2];
        int[][] distancesRed = new int[n][2];
        int[][] distancesBlue = new int[n][2];
        for (int i = 1; i < n; i++) {
            distancesRed[i][0] = Integer.MAX_VALUE;
            distancesRed[i][1] = Integer.MAX_VALUE;
            distancesBlue[i][0] = Integer.MAX_VALUE;
            distancesBlue[i][1] = Integer.MAX_VALUE;
        }
        colorsRed[0][0] = GRAY;
        List<Integer> queueRed = new ArrayList<Integer>();
        List<Integer> queueRedColors = new ArrayList<Integer>();
        queueRed.add(0);
        queueRedColors.add(RED);
        while (!queueRed.isEmpty()) {
            int node = queueRed.remove(0);
            int color = queueRedColors.remove(0);
            int nextColor = RED + BLUE - color;
            int distance = distancesRed[node][color - RED];
            List<Integer> nextNodes = color == RED ? mapRed.get(node) : mapBlue.get(node);
            if (nextNodes != null) {
                for (int nextNode : nextNodes) {
                    if (colorsRed[nextNode][nextColor - RED] == WHITE) {
                        colorsRed[nextNode][nextColor - RED] = GRAY;
                        if (distancesRed[nextNode][nextColor - RED] > distance + 1)
                            distancesRed[nextNode][nextColor - RED] = distance + 1;
                        queueRed.add(nextNode);
                        queueRedColors.add(nextColor);
                    }
                }
            }
            colorsRed[node][color - RED] = BLACK;
        }
        colorsBlue[0][1] = GRAY;
        List<Integer> queueBlue = new ArrayList<Integer>();
        List<Integer> queueBlueColors = new ArrayList<Integer>();
        queueBlue.add(0);
        queueBlueColors.add(BLUE);
        while (!queueBlue.isEmpty()) {
            int node = queueBlue.remove(0);
            int color = queueBlueColors.remove(0);
            int nextColor = RED + BLUE - color;
            int distance = distancesBlue[node][color - RED];
            List<Integer> nextNodes = color == BLUE ? mapBlue.get(node) : mapRed.get(node);
            if (nextNodes != null) {
                for (int nextNode : nextNodes) {
                    if (colorsBlue[nextNode][nextColor - RED] == WHITE) {
                        colorsBlue[nextNode][nextColor - RED] = GRAY;
                        if (distancesBlue[nextNode][nextColor - RED] > distance + 1)
                            distancesBlue[nextNode][nextColor - RED] = distance + 1;
                        queueBlue.add(nextNode);
                        queueBlueColors.add(nextColor);
                    }
                }
            }
            colorsBlue[node][color - RED] = BLACK;
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = Math.min(Math.min(distancesRed[i][0], distancesRed[i][1]), Math.min(distancesBlue[i][0], distancesBlue[i][1]));
            if (ret[i] == Integer.MAX_VALUE)
                ret[i] = -1;
        }
        return ret;
    }
}
