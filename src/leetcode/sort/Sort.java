package leetcode.sort;

/**
 * Created by Diane on 2019/2/7.
 * Goal: 排序算法的实现，包括归并排序，冒泡排序，插入排序，选择排序，快速排序
 */
public class Sort {
    /**
     * 快速排序
     * @param nums
     */
    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int []nums,int start,int end){
        if(start>=end) return;
        int pivot = partition(nums,start,end);
        quickSort(nums,start,pivot-1);
        quickSort(nums,pivot+1,end);
    }
    public int partition(int[] nums,int p,int r)
    {
        int i=p,j;
        int pivot = nums[r];
        for(j = p;j<r;j++){
            if(nums[j]<pivot){
                if(i==j) i++;
                else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                }
            }
        }
        if(i!=r){
            int temp = nums[i];
            nums[i] = nums[r];
            nums[r] = temp;
        }
        return i;
    }


    /**
     * 归并排序
     * @param nums： 待排序的数组
     * 空间复杂度为O(n),时间复杂度为O(nlogn) 是一个稳定排序
     */
    public void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }

    public void mergeSort(int[] nums,int start,int end){
        if(start>=end) return;
        int mid = start+(end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    public void merge(int[] nums,int p,int q,int r){
        int i = p,j=q+1;
        int[] temp = new int[r-p+1];
        int t = 0;
        while(i<=q&&j<=r){
            if(nums[i]<nums[j]) {
                temp[t++]=nums[i++];
            }else {
                temp[t++]=nums[j++];
            }
        }
        int start = i, end = q;
        if(j<=r){
            start = j;
            end = r;
        }//哨兵，判断哪个子数组有剩余的数据
        //将子数组的数据拷贝到临时数组
        while (start<=end){
            temp[t++]=nums[start++];
        }
        //将临时数组复制到现在的数组中
        int k = p;
        while (k<=r){
            nums[k] = temp[k-p];
            k++;
        }
    }

    public static void main(String[] args) {
        Sort sortUtil = new Sort();
        int []nums = {8,5,7,6,3,5,9,2,10};
        sortUtil.mergeSort(nums);
        for(int i:nums) System.out.print(i+"\t");
    }
}
