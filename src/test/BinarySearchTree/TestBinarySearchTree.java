package test.BinarySearchTree;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.BinarySearchTree
 * @created : 2020/6/4
 * @description :
 */
public class TestBinarySearchTree {

    /////////////////
    //      5      //
    //    /   \    //
    //   3    6    //
    //  / \    \   //
    // 2  4     8  //
    /////////////////

    public static void test06(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        bst.preOrder();
        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
        bst.depthFirst();
        System.out.println();
        bst.breadthFirst();
//        System.out.println(bst);
    }

    public static void test11(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Random random = new Random();
        int n = 1000;

        // test removeMin
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();

        while(!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);

        // test removeMax
        for(int i = 0 ; i < n ; i ++) {
            bst.add(random.nextInt(10000));
        }

        nums = new ArrayList<>();

        while(!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }

        System.out.println(nums);
    }

    public static void test12(){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Random random = new Random();
        int n = 10000;

        for(int i = 0 ; i < n ; i ++) {
            bst.add(random.nextInt(n));
        }
        // 注意, 由于随机生成的数据有重复, 所以bst中的数据数量大概率是小于n的

        // order数组中存放[0...n)的所有元素
        Integer[] order = new Integer[n];
        for( int i = 0 ; i < n ; i ++ ) {
            order[i] = i;
        }
        // 打乱order数组的顺序
        shuffle(order);

        // 乱序删除[0...n)范围里的所有元素
        for( int i = 0 ; i < n ; i ++ )
            if(bst.contains(order[i])){
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.getSize() );
            }

        // 最终整个二分搜索树应该为空
        System.out.println(bst.getSize());
    }

    // 打乱数组顺序
    private static void shuffle(Object[] arr){
        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {
//        test06();
//        test11();
        test12();
    }
}
