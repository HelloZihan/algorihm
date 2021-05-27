package com.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 复杂度为O(n)
 * @author zhaojun
 */
public class LengthOfLongestSubstring {

    /**
     * "abcabcbb", "dvdf", "abcabcbb"  滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int tmp = 0;
        int p = 0;
        Set<Character> hashSet = new HashSet<>();
        //可以理解为i为左指针，p为右指针
        for (int i = 0; i < s.length(); i++) {
            while (p<s.length() && !hashSet.contains(s.charAt(p))) {
                hashSet.add(s.charAt(p));
                p++;
                tmp++;
            }
            result = Math.max(p - i, result);
            //此处注意，tmp应该是tmp-1，移除掉起始的一个字符，再接着往后走
            //result = Math.max(tmp, result); 跟上面的result计算，两种方式均可以
            tmp = tmp-1;
            hashSet.remove(s.charAt(i));
        }
        return result;
    }
}
