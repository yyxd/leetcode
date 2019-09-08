package contest.contest141;

import java.util.*;

/**
 * Created by Diane on 2019-06-16.
 * Goal:
 */
public class Problem2 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        HashMap<Integer, List<Integer>> labelMax = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            int label = labels[i];
            int value = values[i];
            if(labelMax.get(label) == null) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(value);
                labelMax.put(label,tempList);
            }
            else {
                List<Integer> tempList = labelMax.get(label);
                tempList.add(value);
            }
        }
        labelMax.forEach((label,valueList)-> valueList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }));
        int max = 0;
        List<Integer> getNums = new ArrayList<>();
        for(int l:labelMax.keySet()){
            for(int i=0;i<use_limit;i++){
               List<Integer> tempList = labelMax.get(l);
               if(tempList.size()-1>=i) getNums.add(tempList.get(i));
               else break;
            }
        }
        getNums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<num_wanted;i++){
            if(getNums.size()-1>=i) max = max+getNums.get(i);
        }
       return max;
    }

    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        int[] values = {9,8,8,7,6}, labels = {0,0,0,1,1};
        int num_wanted = 3, use_limit = 1;
        System.out.println(p2.largestValsFromLabels(values,labels,num_wanted,use_limit));

    }
}
