package acmcoder.xiecheng;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-04.
 * Goal:
 */
public class sci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] ss = s.split(" ");
            for(int i =0;i<ss.length;i++)
                System.out.println(ss[i]);
        }
    }
}
