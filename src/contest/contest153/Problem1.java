package contest.contest153;

/**
 * Created by Diane on 2019-09-08.
 * Goal:
 */
public class Problem1 {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int sd = distance[start];
        int sum = distance[start];
        boolean flag = true;
        int i = (start + 1) % n;
        while (i != start) {
            if (i == destination)
                flag = false;
            sum += distance[i];
            if (flag) {
                sd += distance[i];
            }
            i = (i + 1) % n;
        }
        return Math.min(sd, sum - sd);
    }

    public static void main(String[] args) {
        int[] di = {7, 10, 1, 12, 11, 14, 5, 0};
//        int s = 0,e=3;
        System.out.println(distanceBetweenBusStops(di, 7, 2));
        System.out.println(distanceBetweenBusStops(di, 0, 2));
        System.out.println(distanceBetweenBusStops(di, 0, 3));
    }
}
