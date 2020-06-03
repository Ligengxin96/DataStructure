package test.Arrays;

import Arrays.LoopQueue;

/**
 * @author : ligengxin
 * @version : V1.0
 * @packageName :  test.Arrays
 * @created : 2020/5/20
 * @description :
 */
public class TestLoopQueue {

    public static void test07(){
        LoopQueue<Integer> queue = new LoopQueue();

        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    public static void main(String[] args) {
        test07();
    }
}
