package contest.contest144;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */
public class Problem1 {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");

    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }
}
