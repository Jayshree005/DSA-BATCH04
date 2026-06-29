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
/**class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        
        ListNode temp = head;
        int count = 1;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null) {
            return head;
        }
        
        ListNode nextGroupHead = temp.next;
        temp.next = null;
        
        ListNode reversedHead = reverseList(head); 
        
        head.next = reverseKGroup(nextGroupHead, k);
        
        return reversedHead; 
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}
*/
class Solution {

    public int len(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int N = len(head);
        int groups = N / k;

        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode ansNode = null;

        for (int i = 0; i < groups; i++) {

            ListNode prev = null;
            ListNode curr = currHead;

            for (int j = 0; j < k; j++) {

                ListNode nextNode = curr.next;

                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if (prevHead == null) {
                ansNode = prev;
            } else {
                prevHead.next = prev;
            }

            prevHead = currHead;
            currHead = curr;
        }

        prevHead.next = currHead;

        return ansNode;
    }
}