/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static int lengthOfLinkedList(ListNode temp)
    {
        int count = 0 ;
        while(temp != null)
        {
            temp = temp.next ;
            count++ ;
        }
        return count ;
    }
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0) return head ;
        ListNode temp = head;
        int len = lengthOfLinkedList(temp) ;
        
        k = k % len ;
        if(k == 0) return head ;
        int remaining = len - k ;
        temp = head ;
        
        while(remaining > 1 && temp != null)
        {
            temp = temp.next ;
            remaining-- ;
        }
        ListNode secondHead = temp.next  ;
        temp.next = null ;
        temp = secondHead ;
        while(temp.next != null)
        {
            temp = temp.next ;
        }
        temp.next = head ;
        return secondHead ;
    }
}