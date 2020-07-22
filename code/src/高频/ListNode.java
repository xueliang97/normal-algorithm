package 高频;

import java.util.Scanner;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public  static ListNode con(int n){
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(sc.nextInt());
        ListNode p = head;
        for(int i=1;i<n;i++){
            p.next = new ListNode(sc.nextInt());
            p = p.next;
        }

        return head;
    }

    public static void outPut(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
