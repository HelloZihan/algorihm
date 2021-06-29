package com.jianzhi.offer.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 意思就是要开辟新的空间进行深拷贝，而不是浅拷贝
 */
public class Clone {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * map映射
     * @param pHead
     * @return
     */
    public RandomListNode solve(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>(16);
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode randomListNode = new RandomListNode(head.label);
            map.put(head, randomListNode);
            head = head.next;
        }
        head = pHead;
        while (head != null) {
            RandomListNode randomListNode = map.get(head);
            randomListNode.next = map.get(head.next);
            randomListNode.random = map.get(head.random);
            head = head.next;
        }
        return map.getOrDefault(pHead, null);
    }

    /**
     * 构建新的链表，插入到原链表俩节点之间
     * @param pHead
     * @return
     */
    public RandomListNode solve1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = pHead;
        while (head != null) {
            //每个元素插入到原链表元素的下一个
            RandomListNode randomListNode = new RandomListNode(head.label);
            randomListNode.next = head.next;
            head.next = randomListNode;
            head = randomListNode.next;
        }
        head = pHead;
        while (head != null) {
            head.next.random = head.random == null ? null : head.random.next;
            head = head.next.next;
        }
        head = pHead;
        RandomListNode result = head.next;
        while (head != null) {
            //复原两条链表
            RandomListNode randomListNode = head.next;
            head.next = randomListNode.next;
            randomListNode.next = head.next == null ? null : head.next.next;
            head = head.next;
        }
        return result;
    }


    public static void main(String[] args) {
        Clone clone = new Clone();
        Clone.RandomListNode listNode1 = clone.new RandomListNode(1);
        Clone.RandomListNode listNode2 = clone.new RandomListNode(2);
        Clone.RandomListNode listNode3 = clone.new RandomListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(clone.solve1(listNode1));

    }
}
