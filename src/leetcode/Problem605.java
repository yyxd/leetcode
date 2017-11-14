package leetcode;

/**
 * Created by hh23485 on 2017/11/5.
 */
public class Problem605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int plants = 0;
        if(len ==1){
            if(flowerbed[0]==0){
                plants++;flowerbed[0]=1;
            }
        }else if(len==2){
            if(flowerbed[0]==0&&flowerbed[1]==0){
                plants++;flowerbed[0]=1;
            }
        }else {
            for (int i = 0; i < len; i++) {
                if (i == 0 && i + 1 < len && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    plants++;
                    flowerbed[i] = 1;
                } else if (i == len - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    plants++;
                    flowerbed[i] = 1;
                } else if (i >= 1 && i < len - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    plants++;
                    flowerbed[i] = 1;
                }
            }
        }
        return plants>=n;
    }

    public static void main(String[] args) {
        int []flowerbed = {1,0,0,0,1};
        int n = 1;
        Problem605 problem605 = new Problem605();
        System.out.println(problem605.canPlaceFlowers(flowerbed,n));
        n++;
        int []flowerbed2 = {1,0,0,0,1};
        System.out.println(problem605.canPlaceFlowers(flowerbed2,n));
//        for (int i=0;i<flowerbed.length;i++)
//            System.out.println(flowerbed[i]);
        int []flowerbed1 = {0};
        n=1;
        System.out.println(problem605.canPlaceFlowers(flowerbed1,n));
    }
}
