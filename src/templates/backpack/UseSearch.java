package templates.backpack;

/**
 * Created by Diane on 2019-08-30.
 * Goal:
 */
public class UseSearch {
    int N, V;
    int[] v, w;
    int best;
    
    public void SearchPack(int i, int cur_v, int cur_w) {
        if (i > N) {
            if (cur_w > best)
                best = cur_w;
            return;
        }
        if (cur_v + v[i] <= V) {
            SearchPack(i + 1, cur_v + v[i], cur_w + w[i]);
        }
        SearchPack(i + 1, cur_v, cur_w);
    }
}
