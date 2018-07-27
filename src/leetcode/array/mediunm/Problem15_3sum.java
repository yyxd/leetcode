package leetcode.array.mediunm;
import java.util.*;

/**
 * Created by HinTi on 2018/1/24.
 */
public class Problem15_3sum {
    public static List<List<Integer>> threeSum(int[] nums) {

      List<List<Integer>> answer = new ArrayList<>();
        if (nums.length<3) return answer;
      Arrays.sort(nums);
      for (int i=0;i<=nums.length-3;i++)
      //遍历到倒数第三个数就可以停止
      {
          if(nums[i]> 0 ) break;//遍历到正数，后面的数均大于0，就一定没有三元组解
          if(i>0&&nums[i]==nums[i-1]) continue;//如果nums[i]和nums[i-1]相同，则跳过
          int target = 0 - nums[i];
          int m = i+1,n = nums.length-1;
          while (m<n)
          {
              if(nums[m]+nums[n] == target)
              {
                  List<Integer> res = new ArrayList<>();
                  res.add(nums[i]);
                  res.add(nums[m]);
                  res.add(nums[n]);
                  answer.add(res);
                  m++;
                  while (m<=n&&nums[m]==nums[m-1])//要注意边界条件，防止数组溢出
                      m++;
                  n--;
                  while (n>=m&&nums[n]==nums[n+1])
                      n--;
              } else if(nums[m]+nums[n]<target)
              {
                  m++;
                  while (m<=n&&nums[m]==nums[m-1])
                      m++;
              }
              else{
                  n--;
                  while (n>=m&&nums[n]==nums[n+1])
                      n--;
              }
          }
      }
      return answer;
    }

    public static void main(String[] args) {
        int[] array = {0,0,0};
        List<List<Integer>> result ;
       result = threeSum(array);
       if (result!=null)
       {
           for (List<Integer> ans: result) {
               System.out.println(ans.get(0)+" "+ans.get(1)+" "+ans.get(2));
           }
       }
    }
}
