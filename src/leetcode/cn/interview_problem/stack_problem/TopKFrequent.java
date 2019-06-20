package leetcode.cn.interview_problem.stack_problem;

import java.util.*;

/**
 * Created by HinTi on 2019/6/20.
 * Goal: 前K个高频元素
 * Solution: 利用hashMap 统计数字出现的频率
 * 利用优先队列，对出现的频率进行排序
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        List<Integer> values = new ArrayList<>();
        for (int num:freq.keySet()) {
            values.add(freq.get(num));
        }
        Collections.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int last = values.get(k-1);
        List<Integer> ans =new ArrayList<>();
        for (int num:freq.keySet()) {
            if(freq.get(num)>=last)
                ans.add(num);
        }
        return ans;
    }

    public List<Integer> topKFrequentUseHeap(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        Queue<QueueNode> heap = new PriorityQueue<>(new Comparator<QueueNode>() {
            @Override
            public int compare(QueueNode o1, QueueNode o2) {
                return o1.freq-o2.freq;
            }
        });
        int count =0;
        for(int key:freq.keySet()){
            QueueNode queueNode = new QueueNode(key,freq.get(key));
            if(count<k) {
                heap.offer(queueNode);
                count++;
            }else {
                QueueNode first = heap.peek();
                if (queueNode.freq>first.freq){
                    heap.poll();
                    heap.offer(queueNode);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        Iterator<QueueNode> iterator=heap.iterator();
        while (iterator.hasNext()){
            ans.add(iterator.next().value);
        }
        return ans;
    }
}
class QueueNode{
    int value;
    int freq;
    public QueueNode(int v,int f){
        value = v;
        freq =f;
    }
}