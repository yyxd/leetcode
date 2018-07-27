package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by hh23485 on 2017/11/8.
 */
public class Problem532 {
    public static int findPairs(int[] nums, int k) {
        if(k<0||nums.length<=1) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        int same=0;
        for (int i=0;i<nums.length;i++){
            if(hashMap.keySet().contains(nums[i])){
                if(hashMap.get(nums[i])==1) same++;
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
            else
                hashMap.put(nums[i],1);
        }
        if(k==0) return same;
        Iterator iterator = hashMap.keySet().iterator();
        int ans=0;
        while (iterator.hasNext()){
            Integer m=(Integer)iterator.next();
            if(hashMap.containsKey(m+k)) ans++;
            if(hashMap.containsKey(m-k)) ans++;
        }
        return ans/2;
    }

//    数组排序，滑动窗口寻找K-pairs

    public static int findPairs2(int []nums,int k){
        if(k<0||nums.length<=1) return 0;
        int ans =0,left=0,right=1;
        Arrays.sort(nums);
        while (right<nums.length){
            int firstNum = nums[left],lastNum = nums[right];
            if(nums[right]-nums[left]<k) right++;
            else if(nums[right]-nums[left]>k) left++;
            else{
                ans++;
                while (left<nums.length&&nums[left]==firstNum)
                    left++;
                while ((right<nums.length&&nums[right]==lastNum))
                    right++;
            }
            if(right==left) right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums1={3, 1, 4, 1, 5};
        int []nums2={1,2,3,4,5};
        int []nums3={1,3,1,5,4};
        int []nums4={1,1,2,2,2,4,5,6};

        int k1=2,k2=1,k3=0,k4=0;

        System.out.println(findPairs(nums1,k1));
        System.out.println(findPairs(nums2,k2));
        System.out.println(findPairs(nums3,k3));
        System.out.println(findPairs(nums4,k4));
    }
}
