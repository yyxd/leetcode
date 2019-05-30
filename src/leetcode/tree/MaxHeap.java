package leetcode.tree;

import leetcode.sort.Sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by HinTi on 2019/2/24.
 * Goal: 实现大顶堆的插入，删除操作，大顶堆：根节点的值大于左右子节点的值
 * 堆：是一颗完全二叉树，采用数组(从1开始保存记录)保存节点元素，
 * 节点i ，父节点 i/2, 左子节点 2*i,右子节点 2*i+1;
 */
public class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    public MaxHeap() {
        heap.add(0);
    }

    public int getMaxElement() {
        if (heap.size() > 1) return heap.get(1);
        return 0;
    }

    /**
     * 向大顶堆中插入数据，把数据放到数组的最后一位，然后与父节点进行比较,如果比父节点大，则交换上去
     * @param val ：插入的数据
     */
    public void insert(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        while (index / 2 > 0 && heap.get(index / 2) < heap.get(index)) {
            int temp = heap.get(index);
            heap.set(index, heap.get(index / 2));
            heap.set(index / 2, temp);
            index = index / 2;
        }
    }

    /**
     * 删除堆顶元素：将最后一个元素替换到堆顶，然后自顶向下堆化
     */
    public int pop() {
        if (heap.size() <= 1) return 0;
        int ans = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 1;
        int maxPos;
        while (index < heap.size()) {
            maxPos = index;
            int l = index * 2;
            int r = index * 2 + 1;
            if (l < heap.size() && heap.get(index) < heap.get(l)) maxPos = l;
            if (r < heap.size() && heap.get(maxPos) < heap.get(r)) maxPos = r;
            if (maxPos == index) break;
            int temp = heap.get(index);
            heap.set(index, heap.get(maxPos));
            heap.set(maxPos, temp);
            index = maxPos;
        }
        Iterator iterator = heap.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println("=========pop");
        return ans;
    }

    /**
     * 堆排序，大->小
     */
    public List<Integer> heapSort() {
        List<Integer> sorted = new ArrayList<>();
        while (heap.size() > 1)
            sorted.add(pop());
        return sorted;
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        int[] nums = {2, 3, 5, 6, 23, 46, 42, 9, 6, 8, 6, 343, 5, 67, 28};
        for (int num : nums)
            heap.insert(num);
        List<Integer> res = heap.heap;
        Iterator iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
        List<Integer> ans = heap.heapSort();
        Iterator iterator2 = ans.iterator();
        while (iterator2.hasNext()){
            System.out.print(iterator2.next()+"\t");
        }

    }
}
