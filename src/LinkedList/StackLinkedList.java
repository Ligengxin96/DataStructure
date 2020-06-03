package LinkedList;

import Interface.Arrays.Stack;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  LinkedList
 * @created : 2020/5/28
 * @description :
 */
public class StackLinkedList<T> implements Stack<T> {

    private BasicLinkedList<T> stackLinkedList;

    public StackLinkedList() {
        this.stackLinkedList = new BasicLinkedList();
    }

    // 获取链表栈元素个数
    @Override
    public int getSize() {
        return stackLinkedList.getSize();
    }

    // 判断链表栈是否为空
    @Override
    public boolean isEmpty() {
        return stackLinkedList.isEmpty();
    }

    // 入栈
    @Override
    public void push(T e) {
        stackLinkedList.addFirst(e);
    }

    // 出栈
    @Override
    public T pop() {
        return stackLinkedList.removeFirst();
    }

    // 获取栈顶元素
    @Override
    public T peek() {
        return stackLinkedList.getFirst();
    }

    @Override
    public String toString() {
        return stackLinkedList.toString();
    }
}

