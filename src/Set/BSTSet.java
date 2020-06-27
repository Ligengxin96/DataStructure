package Set;

import BinarySearchTree.BinarySearchTree;
import Interface.Set.Set;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Set
 * @created : 2020/6/27
 * @description :
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bstSet;

    public BSTSet() {
        bstSet = new BinarySearchTree<E>();
    }

    @Override
    public void add(E e) {
        bstSet.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bstSet.contains(e);
    }

    @Override
    public void remove(E e) {
        bstSet.remove(e);
    }

    @Override
    public int getSize() {
        return bstSet.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bstSet.isEmpty();
    }
}
