package contest.contest138;

/**
 * Created by Diane on 2019-05-26.
 * Goal:
 */
public class Problem1053 {
    public static int[] prevPermOpt1(int[] A) {
        if (A.length <= 0) return A;
        int cur = A.length-1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > A[i])
                cur = i-1;
        }
        if (cur == A.length - 1)
            return A;
        int swapValue = A[cur + 1];
        int swapIndex = cur + 1;
        for (int i = cur + 2; i < A.length; i++) {
            if (A[i] >= swapValue && A[i] < A[cur]) {
                swapValue = A[i];
                swapIndex = i;
            }
        }
        A[swapIndex] = A[cur];
        A[cur] = swapValue;
        for (int i:A){
            System.out.print(i+"\t");
        }
        System.out.println();
        return A;
    }

    public static void main(String[] args) {
        int[] A1 = {3, 2, 1};
        int[] A2 = {1, 1, 5};
        int[] A3 = {1, 9, 4,6,7};
        int[] A4 = {3, 1, 1, 3};
//         prevPermOpt1(A1);
//         prevPermOpt1(A2);
         prevPermOpt1(A3);
//         prevPermOpt1(A4);

    }
}
