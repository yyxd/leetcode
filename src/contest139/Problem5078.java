package contest139;

/**
 * Created by Diane on 2019-06-02.
 * Goal:
 */
public class Problem5078 {
    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int[] max,min;
        if(arr1.length>arr2.length)
        {
            max = arr1;
            min = arr2;
        }
        else {
            max = arr2;
            min = arr1;
        }
        int i = min.length-1,j = max.length-1;
        int t = 0;
        while (j>=0){
            if(i>=0)
                max[j] = max[j]+min[i]+t;
            else
                max[j] = max[j]+t;
            if(max[j]==2) {
                max[j] =0;
                t = -1;
            }
            else if(max[j]==-1){
                max[j] = 1;
                t = 1;
            }
            else if(max[j]==3){
                t=-1;
                max[j] = 1;
            }else {
                t = 0;
            }
            i--;j--;
        }
        int[] nums;
        if(t==-1){
            nums=new int[max.length+2];
            nums[0] = 1;
            nums[1] = 1;
            for(int p = 0;p<max.length;p++){
                nums[p+2] = max[p];
            }
        }else if(t==1){
            nums=new int[max.length+1];
            nums[0] = 1;
            for(int p = 0;p<max.length;p++){
                nums[p+1] = max[p];
            }
        }else{
            nums = max;
        }
        int startIndex = 0;
        while (startIndex<nums.length && nums[startIndex]==0){
            startIndex++;
        }
        if(startIndex==nums.length){
            int[] ans = new int[1];
            ans[0] = 0;
            return ans;
        }else if(startIndex==0)
            return nums;
        int[] ans = new int[nums.length-startIndex];
        for(int x =0;x<nums.length-startIndex;x++) {
            ans[x] = nums[startIndex+x];
        }
        return ans;


    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,1,1};
        int[] arr2 = {1};
        int[] nums = addNegabinary(arr1,arr2);
        for(int i:nums){
            System.out.print(i+"\t");
        }
    }

}
