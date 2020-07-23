package Queue;

import Heap.MaxHeap;
import Interface.Arrays.Queue;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Queue
 * @created : 2020/7/23
 * @description :
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> queue;

    public PriorityQueue() {
        this.queue = new MaxHeap<E>();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        queue.add(e);
    }

    @Override
    public E dequeue() {
        return queue.extractMax();
    }

    @Override
    public E getFront() {
        return queue.getMax();
    }
}
