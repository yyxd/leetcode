package leetcode.cn.interview_problem;

/**
 * Created by Diane on 2019-05-24.
 * Goal:
 */
public class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m+n-1;
        int i=m-1,j=n-1;
        while (i>=0&&j>=0){
            if(nums1[i]>nums2[j])
            {
                nums1[end--] = nums1[i--];
            }else {
                nums1[end--] = nums2[j--];
            }
        }
        int index = 0;
        if(j>=0){
            while (index<=j)
            {
                nums1[index] = nums2[index];
                index++;
            }
        }

    }

    public static void main(String[] args) {
        int nums1[] = {0};
        int nums2[] = {1};
        merge(nums1,0,nums2,1);
    }
}
