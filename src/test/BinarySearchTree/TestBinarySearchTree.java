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

    public static void main(String[] args) {
//        test06();
        test11();
    }
}
