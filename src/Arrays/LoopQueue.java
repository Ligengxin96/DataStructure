package Arrays;

import Interface.Arrays.Queue;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  Arrays
 * @created : 2020/5/20
 * @description :
 */
public class LoopQueue<T> implements Queue<T> {
    private int front;
    private int tail;
    private int size;
    private T[] loopQueue;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        loopQueue = (T[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    // 获取元素个数
    @Override
    public int getSize() {
        return size;
    }

    // 判断栈是否为空
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    // 入队
    @Override
    public void enqueue(T t) {
        if ((tail + 1) % loopQueue.length == front) {
            recapacity(getCapacity() * 2);
        }
        loopQueue[tail] = t;
        size++;
        tail = (tail + 1) % loopQueue.length;
    }

    // 出队
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }

        T t = loopQueue[front];
        size--;
        loopQueue[front] = null;
        front = (front + 1) % loopQueue.length;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            recapacity(getCapacity() / 2);
        }

        return t;
    }

    // 获取队列首元素
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return loopQueue[front];
    }

    // 获取队列容量
    public int getCapacity(){
        return loopQueue.length - 1;
    }

    // 改变队列容量
    public void recapacity(int capacity){
        T[] data = (T[])new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            data[i] = loopQueue[i];
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        str.append('[');

        for(int i = front ; i != tail ; i = (i + 1) % loopQueue.length){
            str.append(loopQueue[i]);
            if((i + 1) % loopQueue.length != tail) {
                str.append(", ");
            }
        }

        str.append(']');
        return str.toString();
    }
}
