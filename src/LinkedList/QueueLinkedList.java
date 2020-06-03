package LinkedList;

import Interface.Arrays.Queue;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  LinkedList
 * @created : 2020/5/28
 * @description :
 */
public class QueueLinkedList<T> implements Queue<T> {
    private class Node{
        private T e;
        private Node next;

        public Node(T e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(T e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }
    }

    // head 和 tail 指向的是对首和队尾的位置
    // 所以在入队的时候只需要维护 tail 出队的时候只需要维护下head
    private Node head, tail;
    private int size;

    public QueueLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 获取链表队列的元素个数
    @Override
    public int getSize() {
        return size;
    }

    // 判断链表队列是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 入队
    @Override
    public void enqueue(T e) {
        // tail 是 null 说明队列为空了
        if (tail == null) {
            tail = new Node(e);
            head = tail; // head 和 tail 指向同一个（第一个元素）
        } else {
            tail.next = new Node(e);
            tail = tail.next; // 移动下tail的位置
        }
        size++;
    }

    // 出队
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        Node deleteNode = head;
        head = head.next; // 移动下head的位置
        deleteNode.next = null;
        // 出队后head 是 null 说明为空了 队尾置为空
        if(head == null) {
            tail = null;
        }

        size--;
        return deleteNode.e;
    }

    // 获取队列第一个元素
    @Override
    public T getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(Node current = head; current != null; current = current.next) {
            res.append(current.e + "->");
        }
        res.append("Null");
        return res.toString();
    }
}
