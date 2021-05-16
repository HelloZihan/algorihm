package com.jianzhi.offer.math;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 输入
 * 5,3
 * 返回值
 * 3
 * 如果没有小朋友，请返回-1
 * @author zhaojun
 */
public class LastRemaining {

    /**
     * 递归 推导f(n)与f(n-1)之间的关系，m其实是一个常量。也可以用循环列表
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n,int m) {
        if(n < 1 || m < 1) {
            return -1;
        }
        if(n == 1){
            return 0;
        }
        return (lastRemaining(n-1, m)+m)%n;
    }

    /**
     * dp 假设我们现在有n个人，那么这了n个人杀掉一个人之后，就变成了一个n-1个人的问题了，
     * 这就是一个子问题，dp的思想就应该出来了，那么要如何找到n个人的问题和n-1个人的问题之间的关联呢
     * dp[n-1] n-1个人时存活的是i，那么下一轮之后，存活的是哪个人呢？
     *
     * 递归与dp互为双生，先应用递归找规律， 然后再反推使用dp
     * @param n
     * @param m
     * @return
     */
    public int lastRemainingByDp(int n,int m) {
        //如果只有一个人，那么这个人必然胜出，他的编号是0
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[1] = 0;
        for (int i = 2; i < n+1; i++) {
            dp[i] = (dp[i-1]  + m%i)%i;
        }
        return dp[n];
    }
}
