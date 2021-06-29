package com.jianzhi.offer.string;

/**
 * 
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“nowcoder. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a nowcoder.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 示例1
 * 输入
 * "nowcoder. a am I"
 * 返回值
 * "I am a nowcoder."
 *
 * @author zhaojun
 */
public class ReverseSentence {
    /**
     * 使用最原始的方法，两次翻转，并且所有操作自己来。也是书上的写法。
     * 先翻转整个字符串，并用两个指针变量记录某个单词的首尾，去寻找空格，
     * 当尾部碰到空格，就说明现在记录的范围内的单词需要再翻转，翻转过后，重新维护两个指针。
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        //转换成字符数组
        char[] arr = str.toCharArray();
        //先全部翻转一次
        reverse(arr, 0, arr.length - 1);
        //指向单词第一个字母
        int start = 0;
        //指向单词最后一个字母
        int end = 0;
        while (start < arr.length) {
            if (arr[start] == ' ') {
                //如果start指向的是空格，就换下一个，因为指针要指向的是单词。
                start++;
                end++;
            } else if (end == arr.length || arr[end] == ' ') {
                //要么尾部是空格，要么end刚刚超过数组最后一个角标，这两种情况就应该翻转了
                //end之所以会超过最后角标，是因为当最后一个字符不是空格时，会让end++，所以会越界
                reverse(arr, start, end-1);
                //翻转后，应该重新记录下个单词，因此更新end和start。
                end++;
                start = end;
            } else {
                //到这里就说明，start指的不是空格，end也指的不是空格，说明是正常单词，end++即可
                end++;
            }
        }
        return String.valueOf(arr);
    }
    private void reverse(char[] arr, int begin, int end){
        while(begin<end){
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }
}
