package google.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Diane on 2019-09-16.
 * Goal: 航班预订统计
 */

class FlyPoint implements Comparable<FlyPoint> {

    int index;
    /*
    1 进入航班
    -1 离开
    先离开再进入
     */
    int state;//表示进出状态
    int val;

    public FlyPoint(int index, int state, int val) {
        this.index = index;
        this.state = state;
        this.val = val;
    }


    @Override
    public int compareTo(FlyPoint o) {
        if (this.index == o.index)
            return this.state - o.state;
        else
            return this.index - o.index;
    }
}

public class Problem_1109 {

    public static int[] corpFlightBookings2(int[][] bookings, int n) {
        int [] start = new int[n+2];
        int [] arr = new int[n+2];
        for(int i=0; i<bookings.length; i++)
        {
            start[bookings[i][0]] += bookings[i][2];
            start[bookings[i][1]+1] -= bookings[i][2];
        }
        for(int i=1; i<=n; i++)
            arr[i] += arr[i-1]+start[i];
        return Arrays.copyOfRange(arr,1,arr.length-1);
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        List<FlyPoint> flyPoints = new ArrayList<>();
        for (int i = 0; i < bookings.length; i++) {
            int a = bookings[i][0];
            int b = bookings[i][1];
            int v = bookings[i][2];
            flyPoints.add(new FlyPoint(a, 1, v));
            flyPoints.add(new FlyPoint(b + 1, -1, v));
        }
        Collections.sort(flyPoints);
        int j = 0;
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            while (j < flyPoints.size()) {
                FlyPoint cur = flyPoints.get(j);
                if (cur.index <= i)
                    pre = pre + cur.val * cur.state;
                else
                    break;
                j++;
            }
            ans[i - 1] = pre;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ans = corpFlightBookings(bookings, 5);
        System.out.println(Arrays.toString(ans));
    }
}
