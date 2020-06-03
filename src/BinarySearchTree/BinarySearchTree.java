package BinarySearchTree;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  BinarySearchTree
 * @created : 2020/6/3
 * @description :
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node{
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(E e) {
        this.root = new Node(e);
        size = 1;
    }

    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

      // 添加元素
//    public void add(E e){
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add1(root, e);
//        }
//    }

//    private void add (Node node, E e) {
//        if (e.equals(node.e)){
//            return;
//        }
//        if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//        if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        }
//        if (e.compareTo(node.e) > 0) {
//            add(node.right, e);
//        }
//    }

    // 添加元素
    public void add(E e){
        root = add(root, e);
    }

    private Node add (Node node, E e) {
        if(node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

}
