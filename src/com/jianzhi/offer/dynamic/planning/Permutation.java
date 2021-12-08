package com.jianzhi.offer.dynamic.planning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author zhaojun
 */
public class Permutation {

    private ArrayList<String> result = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        dfs(chars, 0, new StringBuilder());
        return result;
    }

    private void dfs(char[] chars, int index, StringBuilder stringBuilder) {
        if(index == chars.length-1) {
            result.add(new String(chars));
            return;
        }
        //防止chars中有重复
        Set<Character> set = new HashSet<>();
        for(int i=index; i<chars.length; i++) {
            if(set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, i, index);
            dfs(chars, index+1, stringBuilder);
            swap(chars, i, index);
        }
    }
    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
