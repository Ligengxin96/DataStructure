package test.Map;

import Map.LinkedMap;
import test.utils.FileOperation;

import java.util.ArrayList;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Map
 * @created : 2020/7/9
 * @description :
 */
public class TestLinkedMap {
    public static void test06(){
        String filename = "src\\test\\utils\\Resource\\pride-and-prejudice.txt";
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            LinkedMap<String, Integer> map = new LinkedMap<String, Integer>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                }
                else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    public static void main(String[] args) {
        test06();
    }
}
