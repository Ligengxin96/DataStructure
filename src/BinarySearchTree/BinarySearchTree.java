package BinarySearchTree;

import Queue.QueueArray;
import Stack.StackArray;

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

    // 判断是否包含某元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.printf(node.e.toString());
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历
    private void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        System.out.printf(node.e.toString());
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历
    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.printf(node.e.toString());
    }

    // 非递归前序遍历(深度优先遍历)
    public void depthFirst(){
        StackArray<Node> stack  = new StackArray<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.printf(String.valueOf(node.e));
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 非递归
    public void breadthFirst(){
        QueueArray<Node> queue  = new QueueArray<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.printf(String.valueOf(node.e));
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    // 删除最小元素
    public E removeMin(){
       E e = findMin();
       root = removeMin(root);
       return e;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除最大元素
    public E removeMax(){
        E e = findMax();
        root = removeMax(root);
        return e;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 寻找最小值
    public E findMin(){
        if (size == 0) {
            throw new IllegalArgumentException("Tree is empty");
        }
        return findMin(root).e;
    }

    private Node findMin(Node node){
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    // 寻找最大值
    public E findMax(){
        if (size == 0) {
            throw new IllegalArgumentException("Tree is empty");
        }
        return findMax(root).e;
    }

    private Node findMax(Node node){
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    public void remove(E e){
       root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if (node == null) {
            return null;
        }
        // 如果当前节点的值比目标值小,则递归左子树,大则递归右子树
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } 
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } 
        if (e.compareTo(node.e) == 0) {
            // 如果当前节点左子树为空,则直接让右子树替代当前节点
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } 
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }  
            // node.left != null && node.right != null
            Node successor = findMin(node.right);
            successor.right = removeMin(node.right); // 因为这里替代操作,其实已经删除了一个节点了这里,所以不需要size--
            successor.left = node.left; // 这里不知道为什么不能和上一步互换位置,没搞懂
            node.left = node.right = null;
            return successor;
        }
        return node;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append('-');
        }
        return res.toString();
    }

}
