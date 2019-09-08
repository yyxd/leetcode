package templates.backpack;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-03.
 * Goal:
 */
public class backpackComplete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt();
        int[] need = new int[505], value = new int[505], f = new int[100005];
        for (int i = 1; i <= N; i++)
            for (int j = need[i]; j <= M; j++)
                f[j] = Math.max(f[j], f[j - need[i]] + value[i]);

    }
}
