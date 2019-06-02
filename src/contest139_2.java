import java.util.HashMap;
import java.util.Map;

/**
 * Created by HinTi on 2019/6/2.
 * Goal: 翻转任意列得到行中的每一个数全为0或1的最大行数
 * 很巧妙的想法，统计现有的每一行的次数，以及与其相反行
 * 例如001,110，就是一对互补行
 * 行+互补行的个数，可以通过翻转得到全0 和全 1
 * 在经过翻转后能够得到一样
 反转之后能够
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
