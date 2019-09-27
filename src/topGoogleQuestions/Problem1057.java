package topGoogleQuestions;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by HinTi on 2019/9/26.
 * Goal:
 */
class WorkerBike implements Comparable<WorkerBike> {
    int worker;
    int bike;
    int manDistance;

    public WorkerBike(int worker, int bike) {
        this.worker = worker;
        this.bike = bike;
    }


    public int compareTo(WorkerBike o) {
        if (this.manDistance == o.manDistance) {
            if (this.worker == o.worker)
                return this.bike - o.bike;
            return this.worker - o.worker;
        }
        return this.manDistance - o.manDistance;

    }
}

public class Problem1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<WorkerBike> queue = new PriorityQueue<>();
        for (int i = 0; i < workers.length; i++)
            for (int j = 0; j < bikes.length; j++) {
                WorkerBike cur = new WorkerBike(i, j);
                cur.manDistance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                queue.add(cur);
            }
        HashSet<Integer> visitedWorker = new HashSet<>();
        HashSet<Integer> visitedBike = new HashSet<>();
        int[] ans = new int[workers.length];
        while (!queue.isEmpty()) {
            WorkerBike cur = queue.poll();
            if (!visitedWorker.contains(cur.worker) && !visitedBike.contains(cur.bike)) {
                visitedWorker.add(cur.worker);
                visitedBike.add(cur.bike);
                ans[cur.worker] = cur.bike;
            }
        }
        return ans;
    }
}