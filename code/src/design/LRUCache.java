package design;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap+双链表
 */
public class LRUCache {

    class ListNode{
        int val;
        int key;
        ListNode pre;
        ListNode next;
        ListNode(int key,int val){
            this.val = val;
            this.key = key;
            pre = null;
            next = null;
        }
    }

    Map<Integer,ListNode> map;
    ListNode head,tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        // 将节点移动到最后
        node.pre.next = node.next;
        node.next.pre = node.pre;

        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(get(key)!=-1){ //使用自定义get方法直接将节点移动到最后
            map.get(key).val = value;
            return ;
        }
        ListNode nn = new ListNode(key,value);
        map.put(key,nn);
        moveToTail(nn);
        if(map.size()>capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    public void moveToTail(ListNode node){
        node.pre = tail.pre;
        node.next = tail;
        node.pre.next = node;
        node.next.pre = node;
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(10);

    }
}
