package test.Arrays;

import Arrays.BasicArray;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Arrays
 * @created : 2020/5/13
 * @description :
 */
public class TestBasicArray {

    public static void main(String[] args) {

        BasicArray<Integer> arr = new BasicArray<>(20);
        for(int i = 0 ; i < 10 ; i ++) {
            arr.add(i);
        }
        System.out.println(arr);

        arr.add(100, 1);
        System.out.println(arr);

        arr.addInFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeOneElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

}
