package Queue;

import Arrays.BasicArray;
import Interface.Arrays.Queue;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Arrays
 * @created : 2020/5/18
 * @description :
 */
public class QueueArray<T> implements Queue<T> {

    private BasicArray queue;

    public QueueArray(){
        queue = new BasicArray<T>();
    }

    public QueueArray(int capacity){
        queue = new BasicArray<T>(capacity);
    }

    // 获取元素个数
    @Override
    public int getSize() {
        return queue.getSize();
    }

    // 判断栈是否为空
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // 入队
    @Override
    public void enqueue(T t) {
        queue.add(t);
    }

    // 出队
    @Override
    public T dequeue() {
        return (T)queue.remove(0);
    }

    // 获取队列首元素
    @Override
    public T getFront() {
        return (T)queue.get(0);
    }

    // 获取队列的容量
    public int getCapacity() {
        return queue.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        str.append('[');

        for(int i = 0 ; i < queue.getSize() ; i ++){
            str.append(queue.get(i));
            if(i != queue.getSize() - 1) {
                str.append(", ");
            }
        }

        str.append(']');
        return str.toString();
    }
}
