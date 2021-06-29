package com.jianzhi.offer.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 * string caseout = "";
 * 1.读入测试用例字符串casein
 * 2.如果对应语言有Init()函数的话，执行Init() 函数
 * 3.循环遍历字符串里的每一个字符ch {
 *      Insert(ch);
 *      caseout += FirstAppearingOnce()
 * }
 * 2. 输出caseout，进行比较。
 * @author zhaojun
 */
public class CharStream {
    /**
     * 保存每个字符出现的次数
     */
    private Map<Character, Integer> map = new HashMap<>();
    /**
     * 保存字符流
     */
    private StringBuilder str = new StringBuilder();
    /**
     * 用来保存字符只出现一次的第一个位置
     */
    private int index = 0;

    /**
     * Insert one char from stringstream
     * @param ch
     */
    public void Insert(char ch) {
        str.append(ch);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    /**
     * return the first appearence once char in current stringstream
     */
    public char FirstAppearingOnce() {
        while (index < str.length()) {
            if (map.get(str.charAt(index)) == 1) {
                return str.charAt(index);
            }
            index++;
        }
        return '#';
    }
}
