package com.leetcode.hot100;


/**
 *
 * 问题描述：
 * 一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
 * 那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
 * 1、0-1背包：每类物品最多只能装一次
 * 2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
 * 3、完全背包：每类物品可以无限次装进包内
 *
 * 做类似背包问题的题目时，始终记住如果是用二维数组，则每一个格子都要填，如果是一维数组，该行已经被上一次循环填满，所以有的格子可以复用
 *
 * 碰到类似题目可以想象成一个画表格的过程，依次优化，该怎么填每个格子的值
 *
 * https://leetcode-cn.com/circle/discuss/GWpXCM/
 * https://blog.csdn.net/nicolelili1/article/details/89062044 (为什么可以优化成一维空间)
 * https://blog.csdn.net/k_young1997/article/details/76040914 (背包恰好装满问题)
 * https://blog.csdn.net/lanyu_01/article/details/79815801
 * https://tangshusen.me/2019/11/24/knapsack-problem/
 *
 */
public class Pack {

    /**
     * https://blog.csdn.net/lanyu_01/article/details/79815801
     * 0-1背包问题
     * 此题找出了放入包中的元素，如果只计算最大值不找出元素，算出dp[N][V]即为结束即为结束
     *
     * 即 dp[i][j] 表示前 i 件物品放入一个容量为 j 的背包可以获得的最大价值
     * dp[i][j]=max(dp[i−1][j],w[i]+dp[i−1][j−v[i])
     *
     * @param V	背包容量
     * @param N	物品种类
     * @param weight 物品重量
     * @param value	物品价值
     * @return
     */
    public static String ZeroOnePack(int V,int N,int[] weight,int[] value){

        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
            }
        }
        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        //逆推找出装入背包的所有商品的编号
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }
        return numStr;
    }

    /**
     * 0-1背包的优化解法(空间优化之后，无法找出放入了装入了哪些物品。要找出物品必须二维数组)
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     *
     * 内层循环必须逆序循环，否则会覆盖以前的元素，可以理解为，计算数组前面元素最大值时已经使用了背包空间的元素，现在又计算新的可能又使用了，造成了重复使用，所以会有问题
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        //1代表1号物品，为数组中的第0个元素。所以物品是1->N,位于数组的0->N-1的位置
        for(int i=1;i<N+1;i++){
            //此处必须逆序实现，否则会覆盖以前的元素
            for(int j=V;j>=weight[i-1];j--){
                //i=1时，只能装weight[0]这个物品
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }


    /**
     * 第二类背包：完全背包(在0/1背包问题基础上，每种物品有无数件)
     * 思路分析：
     * 01背包问题是在前一个子问题（i-1种物品）的基础上来解决当前问题（i种物品），
     * 向i-1种物品时的背包添加第i种物品；而完全背包问题是在解决当前问题（i种物品）
     * 向i种物品时的背包添加第i种物品。
     * 推公式计算时，f[i][y] = max{f[i-1][y], (f[i][y-weight[i]]+value[i])}，
     * 注意这里当考虑放入一个物品 i 时应当考虑还可能继续放入 i，
     * 因此这里是f[i][y-weight[i]]+value[i], 而不是f[i-1][y-weight[i]]+value[i]。
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public static String completePack(int V,int N,int[] weight,int[] value){
        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    //第i个物品的价值为value[i-1]，所以是加上value[i-1]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
            }
        }
        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }
        return numStr;
    }
    /**
     * 完全背包的第二种解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用顺序来实现
     */
    public static int completePack2(int V,int N,int[] weight,int[] value){

        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //顺序实现
            for(int j=weight[i-1];j<V+1;j++){
                //比较一下与0/1背包的区别，就是正序与逆序的区别
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }
}
