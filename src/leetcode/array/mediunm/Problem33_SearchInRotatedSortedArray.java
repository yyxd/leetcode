package leetcode.array.mediunm;

/**
 * Created by HinTi on 2018/7/18.
 */
public class Problem33_SearchInRotatedSortedArray {
    public int search_once(int[] nums,int target)
    {
        int start = 0;
        int end =nums.length-1;
        while (start<=end){
            int middle = (start+end)/2;
            if(nums[middle]==target) return middle;
            if(nums[start]<=nums[middle]) {
                if (nums[middle] > target && target >= nums[start])
                    end = middle - 1;
                else
                    start = middle+1;
            }

            if(nums[middle]<=nums[end]){
                if(target>nums[middle]&&target<=nums[end])
                    start = middle+1;
                else
                    end = middle-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot==-1)
            return -1;
        int i = binSearch(nums,0,pivot-1,target);
        int j = binSearch(nums,pivot,nums.length-1,target);
        if(i!=-1)return i;
        if(j!=-1) return j;
        return -1;
    }

    public int findPivot(int []nums)
    {
        int start = 0,end = nums.length-1;
        int middle ;
        while (start<end)
        {
            middle = (start+end)/2;
            if(nums[start]<=nums[middle]&&nums[middle]<=nums[end])
                return 0;
            if(nums[start]>nums[middle]&&nums[middle]>nums[end])
                return -1;
            if(nums[start]>nums[middle]){
                if(middle-1>=0&&nums[middle]<nums[middle-1]) return middle;
                end = middle-1;
            }else if(nums[middle]>nums[end]){
                if(middle+1<nums.length&&nums[middle]>nums[middle+1]) return middle+1;
                start = middle+1;
            }
        }
        return 0;
    }
    public int binSearch(int []nums,int low,int high,int target)
    {
        while (low<=high)
        {
            int middle = (low+high)/2;
            if(nums[middle] == target)
                return middle;
            if(target<nums[middle]){
                high = middle-1;
            }else {
                low = middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem33_SearchInRotatedSortedArray ins = new Problem33_SearchInRotatedSortedArray();

      //  System.out.println(ins.search(nums,3));
//        int []nums2 = {5,1,3};
//        System.out.println(ins.search(nums2,1));
        int []nums ={0,3};
        int target = 0;
        System.out.println(ins.search_once(nums,target));
        int nums3[]={3,0};
        int nums4[]={6,7,0};
        int nums5[]={5,6,7,0,1};
        int nums6[] = {5,1,3};
        int nums7[] = {0};
        int nums8[] = {0,0,0};
        System.out.println(ins.search_once(nums3,target));
        System.out.println(ins.search_once(nums4,target));
        System.out.println(ins.search_once(nums5,target));
        System.out.println(ins.search_once(nums6,target));
        System.out.println(ins.search_once(nums7,target));
        System.out.println(ins.search_once(nums8,target));
    }
}
