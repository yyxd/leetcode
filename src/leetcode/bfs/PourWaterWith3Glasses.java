package leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-08.
 * Goal:
 */
public class PourWaterWith3Glasses {
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    public static int target = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        target = in.nextInt();
        System.out.println(bfs());
    }

    public static int bfs() {
        myState cur = new myState(0, 0, 0, 0);
        HashSet<myState> stateSet = new HashSet<>();
        stateSet.add(cur);
        cur.steps = 0;
        LinkedList<myState> queue = new LinkedList<>();
        queue.add(cur);
        int steps = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.a == target || cur.b == target || cur.c == target) return cur.steps;
            //对于当前状态走一步的可能有
            int step = cur.steps + 1;
            // 1. 往某个杯子倒满水
            myState state1 = new myState(a, cur.b, cur.c, step);
            myState state2 = new myState(cur.a, b, cur.c, step);
            myState state3 = new myState(cur.a, cur.b, c, step);

            // 1. a往b  倒水
            int nexta = 0, nextb = 0, nextc = 0;
            nexta = cur.a - cur.b <= 0 ? 0 : cur.a - cur.b;
            nextb = (cur.a + cur.b) <= b ? (cur.a + cur.b) : b;
            nextc = cur.c;
            myState stateab = new myState(nexta, nextb, nextc, step);

            // a 往c 倒水
            nexta = cur.a - cur.c <= 0 ? 0 : cur.a - cur.c;
            nextb = cur.b;
            nextc = (cur.a + cur.c) <= c ? (cur.a + cur.c) : c;
            myState stateac = new myState(nexta, nextb, nextc, step);

            //  b往a 倒水
            nexta = (cur.b + cur.a) <= a ? (cur.b + cur.a) : a;
            nextb = cur.b - cur.a <= 0 ? 0 : cur.b - cur.a;
            nextc = cur.c;
            myState stateba = new myState(nexta, nextb, nextc, step);

            //  b往c 倒水
            nexta = cur.a;
            nextb = cur.b - cur.c <= 0 ? 0 : cur.b - cur.c;
            nextc = (cur.b + cur.c) <= c ? (cur.b + cur.c) : c;
            myState statebc = new myState(nexta, nextb, nextc, step);

            // c 往a 倒水
            nexta = (cur.a + cur.c) <= a ? (cur.a + cur.c) : a;
            nextb = cur.b;
            nextc = cur.c - cur.a <= 0 ? 0 : cur.c - cur.a;
            myState stateca = new myState(nexta, nextb, nextc, step);


            // c 往b 倒水
            nexta = cur.a;
            nextb = (cur.b + cur.c) <= b ? (cur.b + cur.c) : b;
            nextc = cur.c - cur.b <= 0 ? 0 : cur.c - cur.b;
            myState statecb = new myState(nexta, nextb, nextc, step);


            if (!stateSet.contains(state1)) {
                stateSet.add(state1);
                queue.offer(state1);
            }
            if (!stateSet.contains(state2)) {
                stateSet.add(state2);
                queue.offer(state2);
            }

            if (!stateSet.contains(state3)) {
                stateSet.add(state3);
                queue.offer(state3);
            }
            if (!stateSet.contains(stateac)) {
                stateSet.add(stateac);
                queue.offer(stateac);
            }

            if (!stateSet.contains(stateab)) {
                stateSet.add(stateab);
                queue.offer(stateab);
            }
            if (!stateSet.contains(statebc)) {
                stateSet.add(statebc);
                queue.offer(statebc);
            }

            if (!stateSet.contains(stateba)) {
                stateSet.add(stateba);
                queue.offer(stateba);
            }
            if (!stateSet.contains(statecb)) {
                stateSet.add(statecb);
                queue.offer(statecb);
            }

            if (!stateSet.contains(stateca)) {
                stateSet.add(stateca);
                queue.offer(stateca);
            }
        }
        return -1;
    }
}

class myState {
    int a;
    int b;
    int c;
    int steps;

    public myState(int a, int b, int c, int steps) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.steps = steps;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof myState) {
            myState state = (myState) obj;
            return this.a == state.a && this.b == state.b && this.c == state.c;
        }
        return false;
    }
}

