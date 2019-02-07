package leetcode.sort;

/**
 * Created by Diane on 2019/2/7.
 * Goal:
 */
public class Problem69_Sqrt {
    public static int mySqrt(int x) {
        int low = 1,high = x;
        while(low<high){
            int mid = low+(high-low)/2+1;
            if(mid>x/mid){
                high = mid-1;
            }else {
                low = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        mySqrt(8);
    }
}
