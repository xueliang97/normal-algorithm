package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NonRecursiveTraversal {
    //树的非递归遍历，模拟系统栈的过程

    public static TreeNode constructTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;

    }

    static class Command{//操作
        String s; //指令 go 访问，print 打印
        TreeNode node;
        Command(String s,TreeNode node){this.s = s;this.node = node;}
    }
    public static void main(String[] args){
        TreeNode root = constructTree();

        Stack<Command> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        stack.push(new Command("go",root));//初始操作入栈
        while(!stack.isEmpty()){
            Command com = stack.pop();
            if(com.s.equals("print")) {//判断指令是print则输出
                res.add(com.node.val);
            }else{ //因为使用栈操作要倒许入栈，从后往前看就是遍历顺序  后序遍历 其他调正print指令入栈顺序可实现
                stack.add(new Command("print",com.node));
                if(com.node.right!=null)
                    stack.add(new Command("go",com.node.right));
                if(com.node.left!=null)
                    stack.add(new Command("go",com.node.left));
            }
        }
        System.out.print(res);
    }
}
