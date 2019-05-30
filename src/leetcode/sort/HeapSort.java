package leetcode.sort;

/**
 * Created by HinTi on 2019/2/24.
 * Goal: 原址堆排序 使用大顶堆
 * 但是堆排序不如快排的原因是，交换次数过多
 * 不利于CPU缓存 堆化过程中访问的数组下标是1,2,4,8，而不是像快速排序那样局部顺序访问，对CPU缓存不友好
 */
public class HeapSort {

    public void buildHeap(int []a,int n){
        for(int i =n/2;i>=1;i--){
            hepify(a,n,i);
        }
    }
    /**
     * 自顶向下堆化
     * @param a 数组
     * @param n 数组长度
     * @param i 开始的节点
     */
    private void hepify(int[] a,int n,int i){
        while (true){
            int maxPos = i;
            if(2*i<=n&&a[maxPos]<a[2*i]) maxPos = 2*i;
            if(2*i+1<=n&&a[maxPos]<a[2*i+1]) maxPos = 2*i+1;
            if(maxPos==i) break;
            swap(a,i,maxPos);
            i=maxPos;
        }
    }
    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i]= a[j];
        a[j]= temp;
    }

    public void sort(int[] a,int n){
        int index = 1;
        while (index<n){
            swap(a,index,n--);
            hepify(a,n,index);
        }
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] a = {0,7,5,19,8,4,1,20,13,16};
        hs.buildHeap(a,a.length-1);
        hs.sort(a,a.length-1);
        for(int i:a)
            System.out.print(i+"\t");
    }
}
