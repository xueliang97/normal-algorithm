package design;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {
    private Queue<Integer> A;
    private Queue<Integer> B;
    public 用队列实现栈(){
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x){
        A.offer(x);
        //当B队列不为空就把B队列元素转移到A中，交换A、B队列 始终保持A队列在不插入时为空
        while(!B.isEmpty()){
            A.offer(B.poll());
        }
        Queue<Integer> t =  A;
        A = B;
        B = t;

    }

    public int pop(){
        return B.poll();
    }

    public int peek(){
        return B.peek();
    }

    public boolean isEmpty(){
        return B.isEmpty();
    }
}
