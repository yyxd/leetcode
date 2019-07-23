package leetcode.cn.interview_problem.hash_problem;

import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HinTi on 2019/7/4.
 * Goal:
 */
public class FourNumberAdd {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> AB = new HashMap<>();

        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int value= A[i]+B[j];
                AB.put(value,AB.getOrDefault(value,0)+1);
            }
        }
        int count =0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int value= -(C[i]+D[j]);
                count+= AB.getOrDefault(value,0);
            }
        }

       return count;
    }
}