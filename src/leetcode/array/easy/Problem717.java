package leetcode.array.easy;

/**
 * Created by Diane on 2017/12/29.
 */
public class Problem717 {
    public static boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        for(int i=0;i<len;i++)
        {
            if(bits[i]==1)
            {
                i++;
                if(i==len-1) return false;
            }
            if(i==len-1&&bits[i]==1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int []bits = {1,1,1,0,1,0,1,0,0,1,1,0,1};

    }
}
