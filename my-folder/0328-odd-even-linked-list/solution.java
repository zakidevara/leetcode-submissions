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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null) {
            if (prev != null) {
                prev.next = next;
            }
            
            prev = curr;
            curr = next;
            if (curr != null) next = curr.next;
        }
        
        ListNode oddTail = oddHead;
        while (oddTail.next != null) {
            oddTail = oddTail.next;
        }
        oddTail.next = evenHead;
        
        return oddHead;
    }
}
