package Set;

import Interface.Set.Set;
import LinkedList.BasicLinkedList;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Set
 * @created : 2020/6/27
 * @description :
 */
public class LinkedSet<E> implements Set<E> {
    private BasicLinkedList<E> linkedList;
    public LinkedSet() {
        linkedList = new BasicLinkedList<E>();
    }

    @Override
    public void add(E e) {
        if(!linkedList.contains(e)) {
            linkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
