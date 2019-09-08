package microsoft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by HinTi on 2019/9/3.
 * Goal:
 */
class LRUCacheWithLinkedHashMap {
    LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    int capacity;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            int value = linkedHashMap.get(key);
            // 保证每次查询后 都在末尾
            linkedHashMap.put(key, value);
            return value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key))
            linkedHashMap.remove(key);
        else if (linkedHashMap.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = linkedHashMap.entrySet().iterator();
            iterator.next();
            iterator.remove();
            // int firstKey = map.entrySet().iterator().next().getValue();
            // map.remove(firstKey);
        }
        linkedHashMap.put(key, value);
    }
}

class LRUCache {
    ListNode head;
    ListNode tail;
    HashMap<Integer, ListNode> map;
    int size = 0;
    int capacity;

    public LRUCache(int capacity) {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // put 一个原有元素时，是否需要改变呢？
            if (get(key) != value)
                head.next.val = value;
        } else {
            ListNode cur = new ListNode(key, value);
            map.put(key, cur);
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
            cur.next.pre = cur;
            if (size == capacity) {
                ListNode last = tail.pre;
                tail.pre = last.pre;
                last.pre.next = tail;
                int k = last.key;
                map.remove(k);
            } else {
                size++;
            }
        }
    }

}

class ListNode {
    int key;
    int val;
    ListNode pre;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class Problem146_LRUCache {
    public static void main(String[] args) {
        int capacity = 2;

        LRUCache cache = new LRUCache(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));        // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));        // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));        // 返回  4
    }

}