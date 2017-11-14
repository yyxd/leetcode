package leetcode;

/**
 * Created by hh23485 on 2017/10/31.
 * http://www.cnblogs.com/jimmycheng/p/7703350.html
 */
public class Problem665 {
    public static boolean checkPossibility(int[] nums) {
       if(nums.length<3) return true;
       boolean modified = false;
       for(int i=0;i<nums.length-1;i+=1){
           if(nums[i]>nums[i+1]){
               if(modified) return false;
                else {
                    if(i-1<0||nums[i+1]>=nums[i-1])
                        nums[i]=nums[i+1];
                    else
                        nums[i+1]=nums[i];
                    modified = true;
               }
           }
       }
       return true;
    }

    public static void main(String[] args) {
        int []nums1={4,2,3};
        int []nums2={4,2,1};
        int []nums3={3,4,2,3};
        int []nums4={3,3,2,2};
        System.out.println((checkPossibility(nums1)));
        System.out.println((checkPossibility(nums2)));
        System.out.println((checkPossibility(nums3)));
        System.out.println((checkPossibility(nums4)));
    }
}
