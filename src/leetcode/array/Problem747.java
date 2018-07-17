package leetcode.array;

/**
 * Created by HinTi on 2018/1/18.
 */
public class Problem747 {
    public static int dominantIndex(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            }else if(nums[i]<max1&&nums[i]>max2){
                max2 = nums[i];
            }
        }
        if(max1>= 2*max2)
            return index;
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0,0,0,1};
        System.out.print(dominantIndex(array));
    }
}
