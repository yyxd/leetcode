package acmcoder.huawei;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-25.
 * Goal:
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s==null) System.out.println();
        else {
            String[] strs = s.split(" ");
            if (strs.length >= 2) {
                String os = strs[0];
                String key = strs[1];
                String replece = "";
                for (int i = 0; i < key.length(); i++)
                    replece = replece + "*";
                String ans = os.replaceFirst(key, replece);
                System.out.println(ans);
            } else if (strs.length >= 1) {
                System.out.println(strs[0]);
            } else
                System.out.println();
        }
    }
}
