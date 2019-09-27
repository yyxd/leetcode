package topGoogleQuestions;

/**
 * Created by HinTi on 2019/9/24.
 * Goal:
 */
public class Problem1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // calculate each words frequency of the smallest character
        int[] res = new int[2000 + 5];
        int size = 0;
        for (String word : words) {
            int freq = getFreqofSmallestCharacter(word);
            res[freq] += 1;
            if (freq > size)
                size = freq;
        }
        // calculate prefix sum res[i] means the count of strings frequency>= i
        for (int i = size - 1; i >= 0; i--)
            res[i] = res[i + 1] + res[i];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int freq = getFreqofSmallestCharacter(query);
            ans[i] = freq >= size ? 0 : res[freq + 1];
        }
        return ans;
    }

    public int getFreqofSmallestCharacter(String s) {
        char minChar = 'z';
        int freq = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == minChar)
                freq++;
            else if (ch < minChar) {
                minChar = ch;
                freq = 1;
            }
        }
        return freq;
    }
}