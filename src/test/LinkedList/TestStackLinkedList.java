package test.LinkedList;

import LinkedList.StackLinkedList;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  test.LinkedList
 * @created : 2020/5/28
 * @description :
 */
public class TestStackLinkedList {

    public static void test06() {
        StackLinkedList<Integer> stack = new StackLinkedList();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        stack.push(123);

        System.out.println(stack);
    }

    public static void main(String[] args) {
        test06();
    }
}
