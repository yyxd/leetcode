package contest142;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HinTi on 2019/6/23.
 * Goal:
 */
public class Problem2 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer,Integer> point_pasasger = new HashMap<>();
        for (int i = 0; i < trips.length; i++) {
            int curPass = trips[i][0];
            for(int j=trips[i][1];j<trips[i][2];j++){
                point_pasasger.put(j,point_pasasger.getOrDefault(j,0)+curPass);
                if(point_pasasger.get(j)>capacity) return false;
            }
        }
        return true;
    }
}