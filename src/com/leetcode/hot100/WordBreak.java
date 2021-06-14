package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *  拆分时可以重复使用字典中的单词。
 *  你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 *  输入: s = "leetcode", wordDict = ["leet", "code"]
 *  输出: true
 *  解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 *  输入: s = "applepenapple", wordDict = ["apple", "pen"]
 *  输出: true
 *  解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *  注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 *  输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *  输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class WordBreak {
    /**
     * 回溯  超时！！！
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        for (String w : wordDict) {
            boolean result = wordBreak(s.replaceFirst(w, ""), wordDict);
            if(result) {
                return true;
            }
        }
        return false;
    }

    /**
     * dp
     * dp[i] 表示字符串s前i个字符组成的字符串s[0..i-1]是否能被空格拆分成若干个字典中出现的单词
     * dp[i] 与 dp[i-j]的关系是dp[i-j] && wordDict 是否包含子串s[i-j..i-1]
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                //dp默认值是false 任意一个为true则为true
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                //剪枝 快递跳出内层循环
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(new WordBreak().wordBreak("leetcode", list));
    }
}
