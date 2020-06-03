package test.LinkedList;

import LinkedList.QueueLinkedList;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  test.LinkedList
 * @created : 2020/5/28
 * @description :
 */
public class TestQueueLinkedList {

    public static void test07() {
        QueueLinkedList<Integer> queue = new QueueLinkedList();

        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
        for(int i = 0 ; i < 7 ; i ++){
            queue.dequeue();
            System.out.println(queue);
        }
    }

    public static void main(String[] args) {
        test07();
    }
}
