package Heap;

import Arrays.BasicArray;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Heap
 * @created : 2020/7/21
 * @description :
 */
public class MaxHeap<E extends Comparable<E>> {
    private BasicArray<E> heap;

    public MaxHeap() {
        heap = new BasicArray<E>();
    }

    public MaxHeap(int capacity) {
        heap = new BasicArray<E>(capacity);
    }

    public int getSize() {
        return heap.getSize();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public E getMax() {
        if(heap.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return heap.get(0);
    }

    public void add(E e) {
        heap.add(e);
        siftUp(heap.getSize() - 1);
    }

    private void siftUp(int index) {
        // 首先index 不上根节点,其次在判断父节点和当前节点的大小
        while (index > 0 &&  heap.get(parent(index)).compareTo(heap.get(index)) < 0) {
            // 如果子节点大于父节点,交换父子节点的位置
            heap.swap(index, parent(index));
            index = parent(index);
        }
    }

    // 移除最大元素
    public E extractMax(){
        E e = getMax();
        heap.swap(0, heap.getSize() - 1);
        heap.removeLast();
        siftDown(0);
        return e;
    }

    private void siftDown(int index) {
        while (leftChild(index) < heap.getSize()) {
            int childIndex = leftChild(index);
            // 前一个条件确保有右节点, 后一个条件比较左右谁大,如果右边大则下标+1,取右节点和父节点比较
           if (childIndex + 1 < heap.getSize() && heap.get(childIndex + 1).compareTo(heap.get(childIndex)) > 0) {
               childIndex++;
           }

           E child = heap.get(childIndex);

           if (heap.get(index).compareTo(child) < 0) {
                heap.swap(index, childIndex);
                index = childIndex; //上面交换了位置,则当前节点的索引也变化下
           } else {
               break;
           }
        }
    }

    /**
     *
     * @param index 当前索引
     * @return 返回当前索引的父节点索引
     */
    private int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /**
     *
     * @param index 当前索引
     * @return 返回当前索引的左孩子节点
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     *
     * @param index 当前索引
     * @return 返回当前索引的右孩子节点
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
