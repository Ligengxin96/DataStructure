package LinkedList;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  LinkedList
 * @created : 2020/5/26
 * @description :
 */
public class BasicLinkedList<T> {
    private class Node{
        private T e;
        private Node next;

        public Node(T e, Node node) {
            this.e = e;
            this.next = node;
        }

        public Node(T e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }
    }

    private Node virtualHead;
    private int size;

    public BasicLinkedList() {
        virtualHead = new Node();
        size = 0;
    }

    // 在链表的index位置添加新的元素
    public void add(int index, T e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index");
        }

        Node perNode = virtualHead;
        for (int i = 0; i < index; i++) {
            perNode = perNode.next;
        }
        perNode.next = new Node(e, perNode.next);
        size++;
    }

    // 在链表头添加新的元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素
    public void addLast(T e) {
        add(size, e);
    }

    // 获得链表的第index个位置的元素
    public T get(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        Node current = virtualHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    // 获得链表的第一个元素
    public T getFirst(){
       return get(0);
    }

    // 获得链表的最后一个元素
    public T getLast(){
        return get(size - 1);
    }

    // 查找链表中是否有元素
    public boolean contains(T e){
        for(Node current = virtualHead.next; current != null; current = current.next) {
            if (current.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 修改链表的第index个位置的元素
    public void set(int index, T e){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }

        Node current = virtualHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    // 从链表中删除index位置的元素, 返回删除的元素
    public T remove(int index){
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index");
        }
        Node per = virtualHead;
        for (int i = 0; i < index; i++) {
            per = per.next;
        }
        Node deleteNode = per.next;
        per.next = deleteNode.next;
        deleteNode.next = null;
        size--;
        return deleteNode.e;
    }

    // 链表中删除元素
    public void removeElement(T e) {
        Node pre = virtualHead;
        while (pre.next != null) {
            if (e.equals(pre.next.e)) { // 找到了就退出,没找到就看看下一个
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
            }
        }
    }

    // 从链表中删除第一个位置的元素, 返回删除的元素
    public T removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个位置的元素, 返回删除的元素
    public T removeLast(){
       return remove(size - 1);
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return  size == 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(Node current = virtualHead.next; current != null; current = current.next) {
            res.append(current.e + "->");
        }
        res.append("Null");
        return res.toString();
    }
}
