package google_next;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */

import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int v){
        val = v;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

