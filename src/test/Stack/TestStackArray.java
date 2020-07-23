package test.Stack;

import Stack.StackArray;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Arrays
 * @created : 2020/5/14
 * @description :
 */
public class TestStackArray {

    public static void test02(){
        StackArray<Integer> stack = new StackArray();

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
        test02();
    }
}
