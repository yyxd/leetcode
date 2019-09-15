package google.interview;

/**
 * Created by HinTi on 2019/9/12.
 * Goal:
 */
public class Ip2Int {
    int ip2int(String ip) {
        String[] ips = ip.split("\\.");
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            String cur = ips[i];
            int v = Integer.parseInt(cur);
            for (int j = 0; j < 8; j++) {
                int index = 8 * i + j;
                if (getBit(v, j))
                    ans = setBit(ans, index);
            }
        }
        return ans;
    }

    String int2ip(int val) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int cur = 0;
            for (int j = 0; j < 8; j++) {
                int index = i * 8 + j;
                if (getBit(val, index))
                    cur = setBit(cur, j);
            }
            ans.append(cur);
            ans.append(".");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

    // true 代表该位不为0,1代表该位为0
    private boolean getBit(int v, int i) {
        return (v & (1 << i)) != 0;
    }

    // 将对应位置为1
    private int setBit(int num, int i) {
        return num | (1 << i);
    }

    // 将对应位轻零
    private int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static void main(String[] args) {
        Ip2Int ip2Int = new Ip2Int();
        String s1 = "232.196.128.103";
        int val = ip2Int.ip2int(s1);
        System.out.println(val);
        String t = ip2Int.int2ip(val);
        System.out.println(t);
//        String[] ips = s1.split("\\.");
//        for(String s:ips){
//            System.out.println(s);
//        }

    }

}