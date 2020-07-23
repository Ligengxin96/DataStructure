package Exercise;

import Stack.StackArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Exercise
 * @created : 2020/5/18
 * @description :
 */
public class Stack {

    public static boolean isValid(String str) {
        Map map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        StackArray<Character> stack = new StackArray<Character>();

        char[] strAry = str.toCharArray();

        for (int i = 0; i < strAry.length; i++) {
            if(strAry[i] == '(' || strAry[i] == '{' || strAry[i] == '[') {
                stack.push(strAry[i]);
            } else  {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                char value = (char)map.get(top);
                if (strAry[i] != value) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = new String("{[]}");
        boolean result = isValid(str);
        System.out.printf(String.valueOf(result));
    }
}
