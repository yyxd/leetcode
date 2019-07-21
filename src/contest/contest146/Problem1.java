package contest.contest146;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Diane on 2019-07-21.
 * Goal:
 */
class Domino{
    int i;
    int j;
    Domino(int a,int b){
        i = Math.min(a,b);
        j = Math.max(a,b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domino domino = (Domino) o;
        return i == domino.i &&
                j == domino.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
public class Problem1 {
    public int numEquivDominoPairs(int[][] dominoes) {
       int ans = 0;
        Map<Domino,Integer> map = new HashMap<>();
        for(int i=0;i<dominoes.length;i++){
            Domino temp = new Domino(dominoes[i][0],dominoes[i][1]);
            map.put(temp,map.getOrDefault(temp, 0)+1);
        }
        for(Domino key :map.keySet()){
            int n = map.get(key);
            ans = ans+(n*(n-1))/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        Problem1 problem1 = new Problem1();
        int ans = problem1.numEquivDominoPairs(dominoes);
        System.out.println(ans);
    }

}
