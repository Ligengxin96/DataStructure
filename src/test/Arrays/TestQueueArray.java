package test.Arrays;

import Arrays.QueueArray;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Arrays
 * @created : 2020/5/14
 * @description :
 */
public class TestQueueArray {

    public static void test05(){
        QueueArray<Integer> queue = new QueueArray();

        for(int i = 0 ; i < 5 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);

        queue.enqueue(123);

        System.out.println(queue);
    }

    public static void main(String[] args) {
        test05();
    }
}
