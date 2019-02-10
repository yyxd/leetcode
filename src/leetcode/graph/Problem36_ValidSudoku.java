package leetcode.graph;

import java.util.HashMap;

/**
 * Created by Diane on 2019/2/10.
 * Goal: 验证数独是否有效
 */
public class Problem36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer> count = new HashMap<>();
        setDefault(count);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.')
                {
                    if(count.get(board[i][j])==1)
                        return false;
                    count.put(board[i][j],1);
                }
            }
            setDefault(count);
        }

        for(int j=0;j<board[0].length;j++){
            for(int i=0;i<board.length;i++){
                if(board[i][j]!='.')
                {
                    if(count.get(board[i][j])==1)
                        return false;
                    count.put(board[i][j],1);
                }
            }
            setDefault(count);
        }
        for(int p=0;p<board.length;p=p+3){
            for(int q=0;q<board[0].length;q=q+3){
                for(int i=p;i<p+3;i++)
                    for(int j=q;j<q+3;j++){
                        if(board[i][j]!='.')
                        {
                            if(count.get(board[i][j])==1)
                                return false;
                            count.put(board[i][j],1);
                        }
                    }
                setDefault(count);
            }
        }

        return true;
    }

    public void setDefault(HashMap<Character,Integer> count){
        for(char c='0';c<='9';c++)
            count.put(c,0);
    }
}
