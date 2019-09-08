package microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HinTi on 2019/9/5.
 * Goal:
 */
public class TestSet {
    public static void main(String[] args) {
        Set<Set<Integer>> set = new HashSet<>();
        List<Integer> tx = new ArrayList<>();
        tx.add(1);
        tx.add(2);
        tx.add(3);
        tx.add(4);
        tx.add(5);
        Set<Integer> ans1 = new HashSet<>(tx);
        Set<Integer> ans2 = new HashSet<>(tx);
        Set<Integer> ans3 = new HashSet<>(tx);
        set.add(ans1);
        set.add(ans2);
        set.add(ans3);
        System.out.println(ans1==ans2);
        System.out.println(ans1.equals(ans2));
        System.out.println(set.size());
    }
}