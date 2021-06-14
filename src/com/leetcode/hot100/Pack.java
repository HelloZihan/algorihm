package com.leetcode.hot100;

/**
 * 背包问题
 * https://blog.csdn.net/sinat_38650470/article/details/98958868
 * https://blog.csdn.net/u013885699/article/details/80248536
 * @author zhaojun
 */
public class Pack {

    /**
     * 0-1背包问题
     *
     * dp[i][j]表示前i件物品能装入容量为j的背包中的物品价值总和的最大值
     *
     * @param V 背包容量
     * @param N 物品个数
     * @param weight 物品重量 数组weigt中元素的顺序必须是不可改变的，否则可能影响结果
     * @param value 物品价值
     * @return
     */
    public int ZeroOnePack(int V,int N,int[] weight,int[] value){
        //初始化动态规划数组int
        int[][] dp = new int[N+1][V+1];
        //将dp[i][0]和dp[0][j]均置为0
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //由于weight和value数组下标都是从0开始,注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j){
                    //如果第i件物品的重量大于背包容量j,则不装入背包
                    dp[i][j] = dp[i-1][j];
                } else {
                    //把i装进来与不装进来之间，取最大值. 装的话，就是dp[i-1][j-weight[i-1]]+value[i-1]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return dp[N][V];
    }

    /**
     * 注意到上面循环中，dp[i][j]每次获取值，i都是i-1
     * 0/1背包问题 优化成一维数组。空间O(n)
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public int ZeroOnePack1(int V,int N,int[] weight,int[] value){
        //初始化动态规划数组int
        int[][] dp = new int[N+1][V+1];
        //将dp[i][0]和dp[0][j]均置为0
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //由于weight和value数组下标都是从0开始,注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if(weight[i-1] > j){
                    //如果第i件物品的重量大于背包容量j,则不装入背包
                    dp[i][j] = dp[i-1][j];
                } else {
                    //把i装进来与不装进来之间，取最大值. 装的话，就是dp[i-1][j-weight[i-1]]+value[i-1]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return dp[N][V];
    }

    /**
     * 多重背包
     *
     * 需要额外考虑物品的数量问题
     *
     * @param
     */
    public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){
        //初始化动态规划数组
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(weight[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=0;k<maxV+1;k++){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }
        return dp[N][V];
    }

    /**
     * 完全背包
     * 思路分析：
     * 注意这里当考虑放入一个物品 i 时应当考虑还可能继续放入 i，
     * 因此这里是dp[i][j-weight[i]]+value[i], 而不是dp[i-1][j-weight[i]]+value[i]。
     * 放第i件物品。这里的处理和01背包有所不同，因为01背包的每个物品只能选择一个
     * *因此选择放第i件物品就意味着必须转移到dp[i-1][v-w[i]]这个状态；但是完全背包
     *问题不同，完全背包如果选择放第i件物品之后并不是转移到dp[i-1][v-w[i]]这个状态，
     *而是转移到dp[i][v-w[i]]，这是因为每种物品可以放任意件（注意有容量的限制，因此
     *还是有限的），放了第i件物品后还可以继续放第i件物品，直到第二维的v-w[i]无法保
     *持大于等于0为止。
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public static int completePack(int V,int N,int[] weight,int[] value){
        int[][] dp = new int[N+1][V+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
            }
        }
        return dp[N][V];
    }
}
