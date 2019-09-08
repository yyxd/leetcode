package contest.contest153;

/**
 * Created by Diane on 2019-09-08.
 * Goal:
 */
public class Problem2 {
    public static String dayOfTheWeek(int day, int month, int year) {
        // 1970-1-1  周四
        int[] dayOfmonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int yd = 0;
        for (int y = 1970; y < year; y++) {
            yd += 365;
            if ((y % 400) == 0 || ((y % 100) != 0 && (y % 4) == 0))
                yd++;
        }
        int md = 0;
        for (int m = 1; m < month; m++) {
            md += dayOfmonth[m - 1];
        }
        if (((year % 400) == 0 || ((year % 100) != 0 && (year % 4) == 0)) && month > 2)
            md++;
        System.out.printf("%d %d %d\n", yd, md, day - 1);
        int ans = (yd + md + day - 1) + 4;
        return transfer(ans % 7);

    }

    public static String transfer(int i) {
        switch (i) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "invalid";
        }
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(1, 1, 1970));
        System.out.println(dayOfTheWeek(29, 2, 2000));
        System.out.println(dayOfTheWeek(8, 9, 2019));
    }
}


