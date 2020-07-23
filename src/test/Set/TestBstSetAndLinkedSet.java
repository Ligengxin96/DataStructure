package test.Set;

import java.util.ArrayList;

import Interface.Set.Set;
import Set.BSTSet;
import Set.LinkedSet;
import test.utils.FileOperation;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Set
 * @created : 2020/6/27
 * @description :
 */
public class TestBstSetAndLinkedSet {

    private static double testSet(Set<String> set, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "src\\test\\utils\\Resource\\pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<String>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedSet<String> linkedListSet = new LinkedSet<String>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

        System.out.println("\nLinked List Set / BST Set = " + time2 / time1);
    }
}
