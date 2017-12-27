package leetcode.array;


/**
 * Created by Diane on 2017/11/17.
 */
public class Problem414 {
    public static int thirdMax(int[] nums) {
        if (nums.length==0) return 0;
        else if(nums.length==1) return nums[0];
        else if(nums.length==2) return Math.max(nums[0],nums[1]);
        Integer max1=null ,max2=null,max3=null;
        for(int i=0;i<nums.length;i++){
            if(max1==null||nums[i]>max1){
                max3 = max2;max2=max1;max1=nums[i];
            }else if((max2==null||nums[i]>max2)&nums[i]!=max1){
                max3 = max2;max2=nums[i];
            }else if(max2!=null&(max3==null||nums[i]>max3)){
                if(max2!=nums[i]&&nums[i]!=max1)
                max3=nums[i];
            }
        }
        if(max3!=null)
            return max3;
        return max1;
    }

    public static void main(String[] args) {
        int []nums = {3, 2, 1};
        int []nums2={1,2,3,4};
        int []nums3={1,2};
        int []nums4={1,2,2,5,1,5};
        int []nums5={2,2,1};
        int []nums6={Integer.MIN_VALUE,2,1};
        int []nums7={1,1,2,1,1};
        System.out.println(thirdMax(nums));
        System.out.println(thirdMax(nums2));
        System.out.println(thirdMax(nums3));
        System.out.println(thirdMax(nums4));
        System.out.println(thirdMax(nums5));
        System.out.println(thirdMax(nums6));
        System.out.println(thirdMax(nums7));
    }
}
