package test.LinkedList;

import LinkedList.BasicLinkedList;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  test.LinkedList
 * @created : 2020/5/28
 * @description :
 */
public class TestBasicLinkedList {

    public static void test04() {
        BasicLinkedList<Integer> linkedList = new BasicLinkedList();

        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    public static void main(String[] args) {
        test04();
    }
}
