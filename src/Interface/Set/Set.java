package Interface.Set;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Interface.Set
 * @created : 2020/6/27
 * @description :
 */
public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
