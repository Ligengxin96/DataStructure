package Arrays;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Arrays
 * @created : 2020/5/13
 * @description :
 */
public class BasicArray<T> {
    private int size;
    private T[] data;

    // 如果不给容量默认为10
    public BasicArray() {
        this(10);
    }

    /**
     * 构造函数 初始化容量
     * @param capacity 数组容量
     */
    public BasicArray(int capacity) {
        size = 0;
        data = (T[])new Object[capacity];
    }

    /**
     * 构造函数
     * @param ary 一个数组
     */
    public BasicArray(T[]  ary) {
        size = ary.length;
        data = (T[])new Object[ary.length];
        for(int i = 0 ; i < ary.length ; i ++) {
            data[i] = ary[i];
        }
    }

    /**
     * 添加元素
     * @param t 元素
     * @param index 添加元素在数组中的位置
     */
    public void add(T t, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        if (size == data.length) {
            recapacity(data.length * 2);
        }

        for(int i = size - 1; i >= index; i --) {
            data[i + 1] = data[i];
        }

        data[index] = t;
        size++;
    }

    /**
     * 添加元素(默认追加到尾部)
     * @param t
     */
    public void add(T t) {
        add(t, size);
    }

    /**
     * 添加元素到数组的第一的位置
     * @param t
     */
    public void addInFirst(T t) {
        add(t, 0);
    }

    /**
     * 查找是否包含某元素
     * @param t 目标元素
     * @return 存在返回true 否则返回 false
     */
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某元素
     * @param t 目标元素
     * @return 找到了返回下标 没找到返回 -1
     */
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取某元素
     * @param index 下标
     * @return 该下标位置的元素
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        return data[index];
    }

    /**
     * 获取数组容量
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组元素的数量
     * @return 数组元素的数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     * @return 数组为空返回true 反之返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 通过下标删除元素
     * @param index 需要删除元素的下标
     * @return 被删除的元素
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        T t = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        data[size] = null;

        // 如果date.length = 1的时候 data.length / 2 等于 0 导致创建一个容量为0的数组
        if (size == data.length / 4 && data.length / 2 != 0) {
            recapacity(data.length / 2);
        }

        return t;
    }

    /**
     * 删除指定的元素
     * @param t 需要删除的元素
     */
    public void removeOneElement(T t) {
        int index = find(t);
        remove(index);
    }

    /**
     * 删除数组中第一个元素
     * @return 被删除的元素
     */
    public T removeFirst() {
       return remove(0);
    }

    /**
     * 删除数组中最后一个元素
     * @return 被删除的元素
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 修改指定位置的元素
     * @param t 修改后的元素
     */
    public void set(T t,int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }
        data[index] = t;
    }

    /**
     * 扩容
     */
    private void recapacity(int capacity){
        T[] newData = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 交换两个元素的位置
    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        str.append('[');

        for(int i = 0 ; i < size ; i ++){
            str.append(data[i]);
            if(i != size - 1) {
                str.append(", ");
            }
        }

        str.append(']');
        return str.toString();
    }
}
