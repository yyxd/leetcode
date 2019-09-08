package contest.contest142;

/**
 * Created by HinTi on 2019/6/23.
 * Goal: 二分搜索
 */
public class Problem3 {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int mountainHigh = getMid(mountainArr);
        int ans = mountainHigh;
        if(mountainArr.get(mountainHigh)==target)
            return ans;
        if((ans = solve(mountainArr,mountainHigh,target))!=-1)
            return ans;
        else if((ans = solve2(mountainArr,mountainHigh,target))!=-1)
            return ans;
        return ans;
    }

    public static int getMid(MountainArray mountainArr) {
        int low = 0, high = mountainArr.length();
        int len = high;
        int mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low) / 2;
            int midValue = mountainArr.get(mid);
            if ((mid == 0 || (mid - 1 >= 0 && midValue >= mountainArr.get(mid - 1))) && ((mid == len - 1) || midValue >= mountainArr.get(mid + 1)))
                return mid;
            if (mid - 1 >= 0 && midValue < mountainArr.get(mid - 1))
                high = mid - 1;
            else
                low = mid+1;
        }
        return high;
    }

    public static int solve(MountainArray mountainArr,int mountainHigh,int target){
        int low = 0,high = mountainHigh-1;
        int ans = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            int midValue = mountainArr.get(mid);
            if(midValue==target)
                return mid;
            if(midValue<target)
                low = mid+1;
            else
                high = mid-1;
        }
        return ans;
    }
    public static int solve2(MountainArray mountainArr,int mountainHigh,int target){
        int low =  mountainHigh-1,high = mountainArr.length()-1;
        int ans = -1;
        while (low<=high){
            int mid = low+(high-low)/2;
            int midValue = mountainArr.get(mid);
            if(midValue==target)
                return mid;
            if(midValue<target)
                high = mid-1;
            else
                low = mid+1;
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums={0,3,5,7,9,8,6,4,2};
        MountainArray mountainArr = new MountainArray(nums);
        System.out.println(findInMountainArray(1,mountainArr));
    }
}

class MountainArray {
    int[] mountainAray;

    MountainArray(int[] mountainAray) {
        this.mountainAray = mountainAray;
    }

    public int get(int index) {
        return mountainAray[index];
    }

    public int length() {
        return mountainAray.length;
    }
}