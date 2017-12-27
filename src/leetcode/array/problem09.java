package leetcode.array;

import java.util.Scanner;

public class problem09 {
    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int reverseNumber=0;
        int originNumber =x ;
        while(x>0){
            reverseNumber=reverseNumber*10+x%10;
            x/=10;
        }
//        System.out.println("Reverse Number = "+reverseNumber);
        if(reverseNumber == originNumber){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i<5;i++) {
            int number = scanner.nextInt();
           System.out.println("Result = "+isPalindrome(number));

        }
    }
}
