package leetcode.array.easy;
/**
 * Created by HinTi on 2017/12/27.
 */
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j=n-1,k=m+n-1;
        while (i>-1&&j>-1)
            nums1[k--]=(nums1[i]>nums2[j])?nums1[i--]:nums2[j--];
        while (j>-1)
            nums1[k--]=nums2[j--];
    }

    public static void main(String[] args) {
        int A[] = new int[20];
        for(int i = 0;i<6;i++)
        {
            A[i] = 2*i+1;
        }
        int []B={2,4,6,8,10};
        Problem88 problem88 = new Problem88();
        problem88.merge(A,6,B,5);
        for (int i=0;i<11;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
}
