package google.stage3;

import java.util.Arrays;

/**
 * Created by HinTi on 2019/9/16.
 * Goal:
 */
class Coord implements Comparable<Coord>{
    public Coord(int c, int r, int val) {
        _c = c;
        _r = r;
        _val = val;
    }
    public int compareTo(Coord x) {
        return _val - x._val;
    }
    public int _c, _r, _val;
}
public class Compress2DMatrix {
        public void solution(int [][] m) {
            int l = m.length, w = m[0].length;
            Coord [] arr = new Coord[l*w];
            int[] colMax = new int[l], rowMax = new int[w];
            for (int i = 0, count = 0; i < l; i++)
                for (int j= 0; j < w; j++)
                    arr[count++] = new Coord(i, j, m[i][j]);
            Arrays.sort(arr);
             for (int i = 0; i < l*w; i++) {
                Coord c = arr[i];
                m[c._c][c._r] = Math.max(colMax[c._c], rowMax[c._r]) + 1;
                colMax[c._c] = m[c._c][c._r];
                rowMax[c._r] = m[c._c][c._r];
            }
        }

        public static void printSol(int[][]  m) {
            System.out.println("Initial array:");
            for (int i = 0; i<m.length; i++)
                System.out.println(Arrays.toString(m[i]));
            (new Compress2DMatrix()).solution(m);
            System.out.println("Modified array:");
            for (int i = 0; i<m.length; i++)
                System.out.println(Arrays.toString(m[i]));
        }

        public static void main(String[] args) {
            int [][] m = {{7,6},{4,9}};
            printSol(m);
            m = new int[][]{{20, 80, 60, 70},{11, 90, 22, 44},{33, 99, 49, 88}};
            printSol(m);
        }
}