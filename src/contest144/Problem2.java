package contest144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */
public class Problem2 {
    public  int[] corpFlightBookings(int[][] bookings, int n) {
        List<Booking> bookingList = new ArrayList<>();
        for(int i=0;i<bookings.length;i++){
            bookingList.add(new Booking(bookings[i][0],bookings[i][1],bookings[i][2]));
        }
        Collections.sort(bookingList);

        int[] ans = new int[n];
        for (int t = 0; t < bookingList.size(); t++) {
            int ti = bookingList.get(t).i;
            int tj = bookingList.get(t).j;
            int tk = bookingList.get(t).k;
            for(int s = t+1;s<bookingList.size();s++){
                int si = bookingList.get(t).i;
                int sj = bookingList.get(t).j;
                int sk = bookingList.get(t).k;
                if(si>tj) break;
                if(sj<tj)
            }
        }
        return ans;
    }

    class Booking implements Comparable<Booking>{
        int i;
        int j;
        int k;
        Booking(int i,int j,int k){
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public int compareTo(Booking o) {
            return this.i-o.i;
        }
    }

    public static void main(String[] args) {
        int[][] bookings = {
                {3, 3, 5},
                {1, 3, 20},
                {1, 2, 15}
        };
        corpFlightBookings(bookings, 6);
    }


}
