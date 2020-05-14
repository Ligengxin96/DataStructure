package Interface.Arrays;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  PACKAGE_NAME
 * @created : 2020/5/14
 * @description :
 */
public interface Stack<T> {
    int getSize();
    boolean isEmpty();
    void push(T t);
    T pop();
    T peek();
}
