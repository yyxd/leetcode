package five.minutes;

/**
 * Created by HinTi on 2019/5/13.
 * Goal: problem 75 sort colors
 * 原址对0、1、2排序，一遍
 * 利用三路快排的思想，设置两个指针
 */
public class Problem75_SortColors {
    public void sortColors(int[] nums) {
        int zero = -1, two = nums.length;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                if (i != zero) {
                    int temp = nums[zero];
                    nums[zero] = nums[i];
                    nums[i] = temp;
                }
                i++;
            } else if (nums[i] == 2) {
                two--;
                if (i != two) {
                    int temp = nums[two];
                    nums[two] = nums[i];
                    nums[i] = temp;
                }
            } else if (nums[i] == 1) {
                i++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
