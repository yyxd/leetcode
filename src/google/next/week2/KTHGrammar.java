package google.next.week2;

/**
 * Created by HinTi on 2019/7/18.
 * Goal:
 */
public class KTHGrammar {
    public static int kthGrammar(int N, int K) {
        if(K==1) return 0;
        int[] res = new int[K+1];
        res[1] = 0;
        res[2] = 1;
        int power = 2;
        for(int i=3;i<=K;i++){
            if(i> power)
                power = power<<1;
            res[i] = res[power+1-i];
        }
        return res[K];
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(4,5));
    }
}