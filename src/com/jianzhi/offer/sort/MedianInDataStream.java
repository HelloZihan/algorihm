package com.jianzhi.offer.sort;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 排序完毕，取中间的值
 *
 * @author zhaojun
 */
public class MedianInDataStream {
    /**
     * 小顶堆，存放后n/2个元素
     */
    private static PriorityQueue<Integer> min = new PriorityQueue<>();

    /**
     * 大顶堆，存放前n/2个元素
     */
    private static PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            min.add(num);
        } else {
            max.add(num);
        }
        if (!max.isEmpty() && (max.peek() > min.peek())) {
            int temp = max.poll();
            max.add(min.poll());
            min.add(temp);

        }
        count++;

    }

    public Double GetMedian() {
        if (count % 2 == 0) {
           return (min.peek() + max.peek())/2.0;
        } else {
           return Double.valueOf(min.peek());
        }
    }
}
