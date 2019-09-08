package google_next;

/**
 * Created by Diane on 2019-07-07.
 * Goal:
 */
public class Problem4 {
    public static void main(String[] args) {
        int[] A = {11,13};
        int[] ans = findNext(A, A.length);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+"\t");
        }
    }

    public static int[] findNext(int[] A, int n) {
        int[] ans = new int[n];
        for(int i=0;i<n;i++)
            ans[i] = -1;
        for (int i = 1; i < A.length; i++) {
            for(int j=0;j<i;j++){
                if(A[i]>A[j]){
                    if(ans[j]==-1)
                        ans[j] = A[i];
                    else
                        ans[j] = Math.min(A[i],ans[j]);
                }
            }
        }
        return ans;
    }
}
