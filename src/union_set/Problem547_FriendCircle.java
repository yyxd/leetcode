package union_set;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class Problem547_FriendCircle {
    int[] parent;

    // 初始化，使每个节点的父节点指向自己
    public void init(int size) {
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++)
            parent[i] = i;
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
        // 路径优化
        parent[i] = pj;
        return true;
    }

    public int findParent(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public int findCircleNum(int[][] M) {
        int count = M.length;
        init(count);
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M[i].length; j++) {
                if (M[i][j] == 1 && merge(i, j))
                    count--;
            }
        }
        return count;
    }

    public int[] findRedundantConnection(int[][] edges) {
        init(edges.length);
        int[] ans = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(!merge(u,v)) {
                ans[0] = u;
                ans[1] =v;
                return ans;
            }
        }
        return ans;
    }
}
