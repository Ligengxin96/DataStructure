package Arrays;

import Interface.Arrays.Stack;

/**
 * @author : Mr.Li
 * @version : V1.0
 * @packageName :  Arrays
 * @created : 2020/5/14
 * @description :
 */
public class StackArray<T> implements Stack<T> {
    private BasicArray stack;

    public StackArray(){
        stack = new BasicArray<T>();
    }

    public StackArray(int capacity){
        stack = new BasicArray<T>(capacity);
    }

    // 获取容量
    public int getCapacity() {
        return stack.getCapacity();
    }

    // 获取元素个数
    @Override
    public int getSize() {
        return stack.getSize();
    }

    // 判断栈是否为空
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // 查看栈底元素
    @Override
    public T peek() {
        return (T) stack.get(0);
    }

    // 移除栈顶元素
    @Override
    public T pop() {
        return (T) stack.remove(stack.getSize() - 1);
    }

    // 入栈
    @Override
    public void push(T t) {
       stack.add(t);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("stack: size = %d , capacity = %d\n", getSize(), getCapacity()));
        str.append('[');

        for(int i = 0 ; i < stack.getSize() ; i ++){
            str.append(stack.get(i));
            if(i != stack.getSize() - 1) {
                str.append(", ");
            }
        }

        str.append(']');
        str.append(": stack top");
        return str.toString();
    }

}
