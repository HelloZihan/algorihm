package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhaojun
 */
public class LetterCombinations {

    private String[] s = new String[] {"", "abc", "def", "ghi", "jkl", "mno","pqrs","tuv","wxyz"};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        StringBuilder stringBuilder = new StringBuilder();
        dfs(digits, 0, stringBuilder);
        return result;
    }
    /**
     * 回溯模板：https://zhuanlan.zhihu.com/p/93530380
     */
    private void dfs(String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        int n = digits.charAt(index) - '0'-1;
        for (int i = 0; i < s[n].length(); i++) {
            stringBuilder.append(s[n].charAt(i));
            dfs(digits, index+1, stringBuilder);
            stringBuilder.delete(index,index+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
