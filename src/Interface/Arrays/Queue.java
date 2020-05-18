package Interface.Arrays;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Interface.Arrays
 * @created : 2020/5/18
 * @description :
 */
public interface Queue<T> {

    int getSize();
    boolean isEmpty();
    void enqueue(T t);
    T dequeue();
    T getFront();
}
