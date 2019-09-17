package leetcode.mock.mock1;

/**
 * Created by Diane on 2019-09-10.
 * Goal:
 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int lsteps = 0;
        int rsteps = 0;
        int usteps = 0;
        int dsteps = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    lsteps++;
                    break;
                case 'R':
                    rsteps++;
                    break;
                case 'U':
                    usteps++;
                    break;
                case 'D':
                    dsteps++;
                    break;
                default:
                    break;
            }
        }
        return lsteps == rsteps && usteps == dsteps;
    }
}
