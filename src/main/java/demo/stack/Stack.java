package demo.stack;
/*
java本身提供的Stack类：java.util.Stack

自己实现的Stack类（简易版，未考虑栈满栈空等边界条件）
 */
public class Stack {
    private int[] arr;
    private int top;

    public Stack(int length) {
        this.arr = new int[length];
        this.top = -1;
    }

    public void push(int value){
        arr[++top] = value;
    }

    public int pop(){
        return arr[top--];
    }
}
