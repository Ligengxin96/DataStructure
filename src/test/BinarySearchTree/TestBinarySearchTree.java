package test.BinarySearchTree;

import BinarySearchTree.BinarySearchTree;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.BinarySearchTree
 * @created : 2020/6/4
 * @description :
 */
public class TestBinarySearchTree {

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
        bst.perOrderNormal();
//        System.out.println(bst);
    }

    public static void main(String[] args) {
        test06();
    }
}
