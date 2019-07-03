package contest.contest143;

/**
 * Created by Diane on 2019-06-30.
 * Goal:
 */
public class Problem1 {
    public static int[] distributeCandies(int candies, int num_people) {
        int once = (1+num_people)*num_people/2;
        int adds = num_people*num_people;
        int times = 0;
        int sum =0;
        int []ans = new int[num_people];
        while (sum<=candies){
           sum = sum+once+adds*times;
           times++;
        }
        sum = 0 ;
        if(times>1) times--;
        for (int i = 0; i < ans.length; i++) {
            int cur =  (i+1)*times+num_people*(times-1);
            sum = sum+cur;
            if(sum<=candies)
                ans[i] = cur;
            else {
                ans[i] = candies-sum+cur;
                break;
            }
        }
        int left = candies-sum;
        int k = 0;
        while (left>0){
            int kget = k+1+times*num_people;
            if(left>kget) {
                ans[k] = ans[k] + kget;
                k++;
                k = k%num_people;
                left = left - kget;
            }else {
                ans[k] = ans[k]+left;
                left = 0;
            }
        }
        return ans;
    }

    public static int[] distributeCandies2(int candies, int num_people){
        int[] ans = new int[num_people];
        int sum =0,start = 1, index=0;
        while (sum<candies){
            sum = sum+start;
            if (sum<candies)
                ans[index] = ans[index]+start;
            else
                ans[index] = ans[index]+candies-sum+start;
            start++;
            index++;
            index = index%num_people;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans;
        ans = distributeCandies2(7,4);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
