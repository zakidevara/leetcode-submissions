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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        int i = 1;
        ListNode leftNodePrev = null;
        ListNode leftNode = head;

        while (i <= right) {
            next = curr.next;
            if (i == left) {
                leftNodePrev = prev;
                leftNode = curr;
            }
            if (i == right) {
                leftNode.next = next;
                if (leftNodePrev != null) {
                    leftNodePrev.next = curr;
                }
            }
            if (i > left && i <= right) {
                curr.next = prev;
            }
            prev = curr;
            curr = next;
            i++;
        }

        return left > 1 ? head : prev;
    }
}
