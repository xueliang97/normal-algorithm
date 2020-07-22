package 高频;

import java.util.Scanner;

/**
 * 头插法 从m到n开始头插
 */
public class 从m到n反转链表 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();

        ListNode head = ListNode.con(count);
        ListNode res  = reverseBetween(head,2,4);
        ListNode.outPut(res);


    }

    public static ListNode reverseBetween(ListNode head, int m, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=1;i<m;i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        for(int i=m;i<n;i++){
            ListNode next = start.next;
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return dummy.next;
    }
}
