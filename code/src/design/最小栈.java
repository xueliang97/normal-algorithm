package design;

import java.util.Stack;

public class 最小栈 {
    Stack<Integer> A;
    Stack<Integer> B;
    /** initialize your data structure here. */
    /**
     * 使用辅助栈B如果插入元素小于B栈顶元素 直接插 否则插入B栈顶元素
     */
    public 最小栈() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if(B.isEmpty()){
            B.push(x);
        }
        else if(B.peek()>x){
            B.push(x);
        }else{
            B.push(B.peek());
        }
    }

    public void pop() {
        int x = A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }

    public static void main(String[] args) {

    }
}
