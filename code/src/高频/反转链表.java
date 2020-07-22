package 高频;

import tree.TreeNode;

import java.util.Scanner;

public class 反转链表 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = ListNode.con(n);
        ListNode.outPut(head);
        ListNode node = digui(head);
        System.out.println();
        ListNode.outPut(node);


    }

    public static ListNode dieDai(ListNode head){
        ListNode pre = null,cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode digui(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode node = digui(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
