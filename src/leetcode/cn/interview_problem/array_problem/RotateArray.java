package leetcode.cn.interview_problem.array_problem;

/**
 * Created by HinTi on 2019/5/31.
 * Goal: [1,2,3,4,5,6,7] k=4 => [4,5,6,7,1,2,3]
 *
 * Solution: 互相交换，一个是公式的推导
 * 利用队列的思想
 * 数组翻转:将数组的前n-k个翻转，再将后k个翻转，再将整个数组翻转,时间复杂度为O(n)
 * 或者一个一个数字的转移，将最后一个数字替换到第一位，重复k次即可，但是这个时间复杂度为O(kn)
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        for (int i = 0; i < k; i++) {
            oneStep(nums);
        }

    }
    public void oneStep(int[] nums){
        int cur = nums[nums.length-1];
        for(int i=nums.length-1;i>=1;i--){
            nums[i] = nums[i-1];
        }
        nums[0] = cur;
    }

    public void anotherRotate(int[] nums,int k){
        k = k%nums.length;
       rotateArray(nums,0,nums.length-k-1);
       rotateArray(nums,nums.length-k,nums.length-1);
       rotateArray(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
    }

    public void rotateArray(int[] nums,int i,int j){
        int mid = (i+j+1)/2;
        while (i<mid){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 公式法
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        RotateArray ra = new RotateArray();
        ra.anotherRotate(nums,4);
    }
}
