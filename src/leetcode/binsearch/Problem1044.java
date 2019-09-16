package leetcode.binsearch;

import java.util.HashSet;

/**
 * Created by Diane on 2019-09-09.
 * Goal:
 */
public class Problem1044 {
    public static String longestDupSubstring(String S) {
        int[] nums = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            nums[i] = ch - 'a';
        }
        int l = 1, r = S.length();
        while (l != r) {
            int mid = l + (r - l) / 2;
            int start = searchHash(S, mid);
            if (start != -1)//对于当前长度的字符串找到了子串，接着去搜索更长的子串
                l = mid + 1;
            else // 无解
                r = mid;
        }//找到第一个不满足的结果
        int start = searchHash(S, l - 1);
        return start == -1 ? "" : S.substring(start, start + l - 1);
    }

    public static String longestDupSubstring2(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = (int) S.charAt(i) - (int) 'a';
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) left = L + 1;
            else right = L;
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    public static int searchHash(String S, int L) {
        long h = 0;
        long al = 1;
        int a = 26;
        int n = S.length();
        long mod = (long) Math.pow(2, 32);
        for (int i = 0; i < L; i++) {
            al = (al * a) % mod;
            int cur = S.charAt(i) - 'a';
            h = (h * 26 + cur) % mod;
        }
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        for (int start = 1; start <= n - L; start++) {
            long first = S.charAt(start - 1) - 'a';
            h = ((h * a) % mod - (first * al) % mod + mod) % mod;
            h = (h + S.charAt(start + L - 1) - 'a') % mod;
            if (seen.contains(h))
                return start;
            seen.add(h);
        }
        return -1;
    }

    public static int search(String S, int target) {
        HashSet<Long> res = new HashSet<>();
        int n = S.length();
        long ans = 0;
        long mod = (long) Math.pow(2, 32);
        long al = 1;
        for (int i = 0; i < target; i++) {
            char ch = S.charAt(i);
            ans = (ans * 26 + (ch - 'a')) % mod;
            al = (al * 26) % mod;
        }
        res.add(ans);
        for (int i = 1; i < n - target + 1; i++) {
            long first = S.charAt(i - 1) - 'a';
            ans = (ans * 26 - first * al % mod + mod) % mod;
            ans = (ans + S.charAt(i + target - 1) - 'a') % mod;
            if (res.contains(ans))
                return i;
            res.add(ans);
        }
        return -1;
    }

    /*
    Rabin-Karp with polynomial rolling hash.
        Search a substring of given length
        that occurs at least 2 times.
        Return start position if the substring exits and -1 otherwise.
        */
    public static int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    public static void main(String[] args) {
        String S = "ababdaebdabedeabbdddbcebaccececbccccebbcaaabaadcadccddaedaacaeddddeceedeaabbbbcbacdaeeebaabdabdbaebadcbdebaaeddcadebedeabbbcbeadbaacdebceebceeccddbeacdcecbcdbceedaeebdaeeabccccbcccbceabedaedaacdbbdbadcdbdddddcdebbcdbcabbebbeabbdccccbaaccbbcecacaebebecdcdcecdeaccccccdbbdebaaaaaaeaaeecdecedcbabedbabdedbaebeedcecebabedbceecacbdecabcebdcbecedccaeaaadbababdccedebeccecaddeabaebbeeccabeddedbeaadbcdceddceccecddbdbeeddabeddadaaaadbeedbeeeaaaeaadaebdacbdcaaabbacacccddbeaacebeeaabaadcabdbaadeaccaecbeaaabccddabbeacdecadebaecccbabeaceccaaeddedcaecddaacebcaecebebebadaceadcaccdeebbcdebcedaeaedacbeecceeebbdbdbaadeeecabdebbaaebdddeeddabcbaaebeabbbcaaeecddecbbbebecdbbbaecceeaabeeedcdecdcaeacabdcbcedcbbcaeeebaabdbaadcebbccbedbabeaddaecdbdbdccceeccaccbdcdadcccceebdabccaebcddaeeecddddacdbdbeebdabecdaeaadbadbebecbcacbbceeabbceecaabdcabebbcdecedbacbcccddcecccecbacddbeddbbbadcbdadbecceebddeacbeeabcdbbaabeabdbbbcaeeadddaeccbcdabceeabaacbeacdcbdceebeaebcceeebdcdcbeaaeeeadabbecdbadbebbecdceaeeecaaaedeceaddedbedbedbddbcbabeadddeccdaadaaeaeeadebbeabcabbdebabeedeeeccadcddaebbedadcdaebabbecedebadbdeacecdcaebcbdababcecaecbcbcdadacaebdedecaadbaaeeebcbeeedaaebbabbeeadadbacdedcbabdaabddccedbeacbecbcccdeaeeabcaeccdaaaddcdecadddabcaedccbdbbccecacbcdecbdcdcbabbeaacddaeeaabccebaaaebacebdcdcbbbdabadeebbdccabcacaacccccbadbdebecdaccabbecdabdbdaebeeadaeecbadedaebcaedeedcaacabaccbbdaccedaedddacbbbdbcaeedbcbecccdbdeddcdadacccdbcdccebdebeaeacecaaadccbbaaddbeebcbadceaebeccecabdadccddbbcbaebeaeadacaebcbbbdbcdaeadbcbdcedebabbaababaacedcbcbceaaabadbdcddadecdcebeeabaadceecaeccdeeabdbabebdcedceaeddaecedcdbccbbedbeecabaecdbba";
        System.out.println(longestDupSubstring(S));
        System.out.println(longestDupSubstring2(S));
    }
}
