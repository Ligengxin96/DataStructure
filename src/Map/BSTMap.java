package Map;

import BinarySearchTree.BinarySearchTree;
import Interface.Map.Map;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Map
 * @created : 2020/7/19
 * @description :
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            if(key == null) {

            }
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    private Node getNode(Node node, K key) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null!");
        }
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public void add(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null!");
        }
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else if(node.key.compareTo(key)  < 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node != null) {
            node.value = value;
        } else {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            return node.value;
        } else {
            return null;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        } else {
            return null;
        }
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if(node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            return node;
        } else if(node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
            return node;
        } else {
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
            Node successor = findMin(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
    }

    private Node findMin(Node node) {
        if(node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public Node removeMin(Node node) {
        Node deleteNode = findMin(node);
        return deleteNode;
    }

    private Node findMax(Node node) {
        if(node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    public Node removeMax(Node node) {
        Node deleteNode = findMax(node);
        return deleteNode;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(root, key);
        return node != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
