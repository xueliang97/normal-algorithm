package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static TreeNode constructTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;

    }

    public static void main(String[] args){
        TreeNode root = constructTree();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return;
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }

                count--;
            }
            res.add(list);
        }
        System.out.print(res);

    }
}
