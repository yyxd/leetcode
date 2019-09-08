package contest.contest142;

/**
 * Created by HinTi on 2019/6/23.
 * Goal:
 */
public class Problem1 {
    public static double[] sampleStats(int[] count) {
        double[] ans = new double[5];//最小值、最大值、平均值、中位数和众数
        int min = -1,max = -1,times=0,sumFreq=0;
        double sum =0;
        boolean flag = true;
        for (int i = 0; i < count.length; i++) {
            if(flag&&count[i]>0){
                ans[0] = i;// 最小值
                flag = false;
            }
            if(count[i]>0)
                ans[1] = i;// 最大值
            if(count[i]>times){
                times = count[i];
                ans[4] = i;//众数，出现次数最多的一次
            }
            sumFreq+=count[i];//求总出现的次数
            sum+=(count[i]*i);//总值
        }
        ans[2] = sum/sumFreq;// 平均值
        int left=0,right =0;
        left = sumFreq/2;
        int temp = 0;
        int leftValue = 0,rightValue =0 ;// 中位数
        for (int i = 0; i < count.length; i++) {
            temp+=count[i];
            if(temp>=left) {
                leftValue=i;
                break;
            }
        }
        temp-=count[leftValue];
        for (int i = leftValue; i < count.length; i++) {
            temp+=count[i];
            if(temp>=(left+1)) {
                rightValue = i;
                break;
            }

        }
        if(sumFreq%2==0) {
            ans[3] = (leftValue+rightValue)/2.0;
        }else{
            ans[3] = rightValue;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] count ={0,1,0,0,2,0,0,0,0,0,0,};
        double[] ans = sampleStats(count);
        for (double an : ans) {
            System.out.println(an);
        }
    }
}