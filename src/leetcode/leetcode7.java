import java.util.Scanner;

/**
 * Created by Diane on 2017/9/19.
 */
public class leetcode7 {
    public static int reverse(int x) {
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        int reverseAns=0,n=0;
        while(x!=0){
            if (reverseAns> INT_MAX/10 || reverseAns < INT_MIN/10){
                return 0;
            }
            reverseAns = reverseAns*10+x%10;
            x/=10;
        }
        return reverseAns;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(reverse(target));
    }
}
