package acmcoder.tencent;

import java.util.Scanner;

/**
 * Created by Diane on 2019-09-20.
 * Goal:
 */
public class ProblemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int iCase = 1; iCase <= T; iCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            int i = 0;
            while (i < s.length() && s.charAt(i) != '8')
                i++;
            int count = 0;
            while(i<s.length()){
                if(s.charAt(i)-'0'>=0 && s.charAt(i)-'9'<=0){
                    count++;
                }
                i++;
            }
            if (count>=11) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
