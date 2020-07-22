package design;

import java.util.Stack;

public class 用栈实现队列 {
    Stack<Integer> A;  // 输入栈
    Stack<Integer> B;  //输出栈

    public static void main(String[] args){


    }

    public 用栈实现队列(){
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x){
        A.push(x);
    }

    public int pop(){
        //当B栈为空，将A栈中数据转移到B栈中，B栈pop
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.pop();
    }

    public int peek(){
        if(B.isEmpty()){
            while(!A.isEmpty()){
                B.push(A.pop());
            }
        }
        return B.peek();
    }

    public boolean empty(){
        return A.isEmpty()&&B.isEmpty();
    }
}
