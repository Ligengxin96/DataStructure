package test.Map;

import Map.BSTMap;
import test.utils.FileOperation;

import java.util.ArrayList;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  test.Map
 * @created : 2020/7/20
 * @description :
 */
public class TestBSTMap {
    public static void test07(){
        String filename = "src\\test\\Resource\\pride-and-prejudice.txt";
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<String, Integer>();
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
        test07();
    }
}
