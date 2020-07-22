package 高频;

import java.util.Scanner;

/**
 * 递归每k个递归一次
 */
public class K个一组反转链表 {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ListNode head = ListNode.con(n);
        ListNode.outPut(reverseKGroup(head,k));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode tail = head,tmp = head;
        for(int i=0;i<k;i++){
            if(tail==null) return head;//不满足K个不反转直接返回头
            tail = tail.next; //指向第k个的下一个节点
        }

        //反转链表
        ListNode pre = null,next = null;
        while(head!=tail){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        tmp.next = reverseKGroup(tail,k);
        return pre;
    }


}
