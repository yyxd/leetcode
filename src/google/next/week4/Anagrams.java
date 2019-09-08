package google.next.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Created by HinTi on 2019/7/24.
 * Goal:
 */
class Word2IntVec {
    private int[] charTimes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word2IntVec)) return false;
        Word2IntVec that = (Word2IntVec) o;
        return Arrays.equals(charTimes, that.charTimes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(charTimes);
    }

    Word2IntVec(int[] charArrays) {
        charTimes = charArrays;
    }
}

public class Anagrams {
    public List<List<String>> groupAnagrams(List<String> words) {
        HashMap<Word2IntVec, List<String>> resultMap = new HashMap<>();
        for (String word : words) {
            int[] res = word2intVec(word);
            Word2IntVec temp = new Word2IntVec(res);
            if(resultMap.containsKey(temp)){
                List<String> stringList = resultMap.get(temp);
                stringList.add(word);
            }
            else {
                List<String> stringList = new ArrayList<>();
                stringList.add(word);
                resultMap.put(temp,stringList);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Word2IntVec key: resultMap.keySet()){
            ans.add(resultMap.get(key));
        }
        return ans;
    }

    /**
     * 对字符串进行桶排序
     * @param word 单词
     * @return int[]
     */
    public int[] word2intVec(String word) {
        int[] charTimes = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            charTimes[index]++;
        }
        return charTimes;
    }
}