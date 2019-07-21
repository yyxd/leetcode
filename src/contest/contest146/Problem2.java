package contest.contest146;

/**
 * Created by Diane on 2019-07-21.
 * Goal:
 */
public class Problem2 {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] answer = bfs(n,red_edges,blue_edges);
        return answer;
    }

    public int[] bfs(int n, int[][] red_edges, int[][] blue_edges) {
        int[] ans = new int[n];
        ans[0] = 0;
        for(int i=1;i<n;i++){
            ans[i] = -1;
        }
        for (int depth = 1; depth < n; depth++) {
            if (depth % 2 != 0) {
                //走过奇数个路径，那么到达该节点的最后一个路径该为红色
                for(int node = 1;node<n;node++)
                    if(ans[node]==-1) {
                        for (int red = 0; red < red_edges.length; red++) {
                            int i = red_edges[red][0];
                            int j = red_edges[red][1];
                            if(ans[i]!=-1&&ans[i]!=depth&&j==node) {
                                ans[node] = depth;
                                break;
                            }
                        }
                    }
            }

            if (depth % 2 == 0){
                // 走过偶数个路径，那么到达该节点的最后一个路径该为蓝色
                for(int node = 1;node<n;node++)
                    if(ans[node]==-1) {
                        for (int blue = 0; blue < blue_edges.length; blue++) {
                            int i = blue_edges[blue][0];
                            int j = blue_edges[blue][1];
                            if(ans[i]!=-1&&ans[i]!=depth&&j==node) {
                                ans[node] = depth;
                                break;
                            }
                        }
                    }
            }
        }
        return ans;
    }

}
