package contest.contest141;

/**
 * Created by Diane on 2019-06-16.
 * Goal:
 */
public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeros++;
            temp[i] = arr[i];
        }
        if (zeros == 0) return;
       int i = 0,j=0;
        while (i < arr.length) {
            if (temp[j]==0) {
                arr[i] = 0;
                if(i+1<arr.length) arr[i+1] = 0;
                j++;
                i+=2;
            }else{
                arr[i++] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 1, 0, 0, 8, 0, 0, 3};
        DuplicateZeros.duplicateZeros(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
