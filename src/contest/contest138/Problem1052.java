package contest.contest138;

/**
 * Created by Diane on 2019-05-26.
 * Goal:
 */
public class Problem1052 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int [] lost = new int[customers.length];
        int ans = 0;
        for(int i=0;i<customers.length;i++){
            lost[i] = grumpy[i]*customers[i];
            ans = ans-(grumpy[i]-1)*customers[i];
        }
        int maxLost = 0;
        if(X>=customers.length)
        {
            for(int i =0;i<customers.length;i++)
                maxLost = maxLost+lost[i];

        }else{
            int lostTemp =0;
            for(int i=0;i<X;i++)
                lostTemp = lostTemp+lost[i];
            maxLost = Math.max(maxLost,lostTemp);
            for(int i=0;i<customers.length-X;i++){
                lostTemp = lostTemp+lost[i+X]-lost[i];
                maxLost = Math.max(maxLost,lostTemp);
            }
        }
        ans = ans+maxLost;
        return ans;
    }

    public static void main(String[] args) {
        int[] customer = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X=3;
        System.out.println(maxSatisfied(customer,grumpy,X));
    }
}
