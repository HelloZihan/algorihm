package com.jianzhi.offer.array;

/** 
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *  对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 *  https://cuijiahua.com/blog/2018/01/basis_51.html
 *  示例1
 *  输入
 *  [1,2,3,4,5]
 *  返回值
 *  [120,60,40,30,24]
 * @author zhaojun
 *
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A.length == 1) {
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        int[] C = new int[A.length];
        C[A.length-1] = 1;
        for (int i = 1, j = A.length-2; i < A.length; i++, j--) {
            B[i] = A[i-1]*B[i-1];
            C[j] = C[j+1] * A[j+1];
        }
        int[] D = new int[A.length];
        for (int i = 0; i < D.length; i++) {
            D[i] = B[i] * C[i];
        }
        return D;
    }
}
