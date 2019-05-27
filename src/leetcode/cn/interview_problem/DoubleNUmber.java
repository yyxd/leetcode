package leetcode.cn.interview_problem;

/**
 * Created by Diane on 2019-05-22.
 * Goal: 给定一个非空整数数组，除了某两个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了两次的元素。
 */
public class DoubleNUmber {
    public static void doubleNumber(int[] nums){
        int x = 0;
        for(int i=0;i<nums.length;i++){
            x ^=nums[i];
        }
        int index = 0,temp = 1;
        while((x&temp)==0){//当x的当前位为0时，x++
            temp = temp<<1;//如果x的当前位为0，那么左移一位
            index++;
        }
        int a =0,b=0;
        for(int i =0;i<nums.length;i++){
            if((nums[i]&temp)==0){
                a ^= nums[i];
            }else{
                b ^= nums[i];
            }
        }

        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,88,89,2,1,5,5,6,6,12,13,14,12,13,14};
        doubleNumber(nums);
    }
}
