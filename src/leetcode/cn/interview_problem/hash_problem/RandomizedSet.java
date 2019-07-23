package leetcode.cn.interview_problem.hash_problem;

import java.util.*;

/**
 * Created by HinTi on 2019/7/4.
 * Goal: 实现一个可以在O(1) 时间内插入，删除和返回一个随机值的数据结构
 * Solution: 使用数组和hashMap 来实现。每次删除的都是数组的最后一个值，如果删除错误的话，将原来的值写入到list中。很奇妙的想法
 */
public class RandomizedSet {
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public RandomizedSet() {
//        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx = map.remove(val);
        int last = list.remove(list.size()-1);
        if(val!=last){
            list.set(idx,last);
            map.put(last,idx);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
       return list.get(index);
    }
}