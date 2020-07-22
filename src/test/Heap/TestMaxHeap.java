package test.Heap;

import Heap.MaxHeap;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Heap
 * @created : 2020/7/21
 * @description :
 */
public class TestMaxHeap {
    public static void test04() {

        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();

        for(int i = 0 ; i < n ; i ++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i ++) {
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 1 ; i < n ; i ++) {
            if(arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");
    }

    public static void test06() {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData1 = new Integer[n];
        for(int i = 0 ; i < n ; i ++) {
            testData1[i] = random.nextInt(Integer.MAX_VALUE);
        }

        Integer[] testData2 = Arrays.copyOf(testData1, n);

        double time1 = testHeap(testData1, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData2, true);
        System.out.println("With heapify: " + time2 + " s");
    }

    private static double testHeap(Integer[] testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>(testData.length);
            for(int num: testData) {
                maxHeap.add(num);
            }
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++) {
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 1 ; i < testData.length ; i ++) {
            if(arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {
//        test04();
        test06();
    }
}
