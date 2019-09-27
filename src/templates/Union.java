package templates;

import java.util.Arrays;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class Union {
    static int[] parent;

    // 初始化，使每个节点的父节点指向自己
    public void init(int size) {
        parent = new int[size + 1];
        for (int i = 1; i <= size; i++)
            parent[i] = parent[i];
    }

    /**
     * 合并 i j 元素
     *
     * @param i i
     * @param j j
     * @return true: i j 使得两颗树合并到一起
     * false  i j 本来就处于同一颗树下
     */
    public boolean merge(int i, int j) {
        int pi = findParent(i);
        int pj = findParent(j);
        if (pi == pj) return false;
        parent[pi] = pj;
        return true;
    }

    public int findParent(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    // 并查集路径优化 , 在查找的过程做优化
    public int findParentWithPath(int i) {
        int t = i;
        while (parent[i] != i) {
            i = parent[i];
        }
        parent[t] = i;
        return i;
    }

}
