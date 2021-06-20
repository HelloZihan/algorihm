package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串s和 p的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class FindAnagrams {

    /**
     * 与最小覆盖子串相似 MinWindow
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s== null || p==null || s.length() < p.length()) {
            return list;
        }
        if (s.equals(p)) {
            list.add(0);
            return list;
        }
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)-'a']++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            int i = s.charAt(right) - 'a';
            if (need[i] > 0) {
                count--;
            }
            need[i]--;
            if (count == 0) {
                while (left < right && need[s.charAt(left) - 'a'] < 0) {
                    need[s.charAt(left) - 'a']++;
                    left++;
                }
                if (right - left+1 == p.length()) {
                    list.add(left);
                }
                need[s.charAt(left)-'a']++;
                left++;
                count++;
            }
            right++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("cbaebabacd","abc"));
    }
}
