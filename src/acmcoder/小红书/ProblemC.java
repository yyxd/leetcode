package acmcoder.小红书;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
class goods implements Comparable<goods> {
    int x;
    int h;

    public goods(int x, int h) {
        this.x = x;
        this.h = h;
    }

    @Override
    public int compareTo(goods o) {
        if (this.x <= o.x && this.h <= o.h)
            return -1;
        else if (this.x > o.x && this.h > o.h)
            return 1;
        else
            return Integer.compare(this.x + this.h, o.x + o.h);
    }
}

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<goods> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            goods g = new goods(a, b);
            pairs.add(g);
        }
        Collections.sort(pairs);
        int[] sold = new int[n];
        sold[0] = 1;
        for (int i = 1; i < pairs.size(); i++) {
            int x = pairs.get(i).x;
            int h = pairs.get(i).h;
            for (int j = 0; j < i; j++) {
                int prex = pairs.get(j).x;
                int preh = pairs.get(j).h;
                if (x >= prex && h >= preh)
                    sold[i] = Math.max(sold[i], sold[j] + 1);
            }
        }
        System.out.println(sold[n - 1]);
    }
}
