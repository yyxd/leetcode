import java.util.HashMap;
import java.util.Map;

/**
 * Created by HinTi on 2019/6/2.
 * Goal:
 */
public class contest139_2 {
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<String,Integer>();

        for (int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            for (int r : row) {
                sb1.append(r);
                sb2.append(1 - r);
            }
            String str1 = sb1.toString();
            String str2 = sb2.toString();

            map.put(str1, map.getOrDefault(str1,0) + 1);
            map.put(str2, map.getOrDefault(str2,0) + 1);
        }

        int res = 0;
        for(int v : map.values()) res = Math.max(res, v);

        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(maxEqualRowsAfterFlips(matrix));

    }
}
