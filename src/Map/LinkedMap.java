package Map;

import Interface.Map.Map;
import LinkedList.BasicLinkedList;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Map
 * @created : 2020/7/8
 * @description :
 */
public class LinkedMap<K, V> implements Map<K, V> {
    private Node virtualHead;
    private int size;

    private class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key){
            this(key, null ,null);
        }

        public Node(){
            this(null, null ,null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    public LinkedMap() {
        this.virtualHead = new Node();
        this.size = 0;
    }

    private Node getNode(K key){
        Node pre = virtualHead.next;
        while (pre != null) {
            if (pre.key.equals(key)) {
                break;
            } else {
                pre = pre.next;
            }
        }
        return pre;
    }

    @Override
    public void add(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key can't be null!");
        }
        Node node = getNode(key);
        if(node == null) {
            virtualHead.next = new Node(key, value, virtualHead.next); // 插入链表的头部
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        } else {
            node.value = value;
        }
    }

    @Override
    public V get(K key) {
        Node node = this.getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public V remove(K key) {
        Node pre = virtualHead.next;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                break;
            } else {
                pre = pre.next;
            }
            // 开始执行删除
            if(pre.next != null) {
                Node deleteNode = pre.next;
                pre.next = deleteNode.next;
                deleteNode.next = null;
                size--;
                return deleteNode.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = this.getNode(key);
        return node != null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}

