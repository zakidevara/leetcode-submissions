# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head == None:
            return head

        tail = head        
        length = 1
        while tail.next != None:
            tail = tail.next
            length += 1

        k = k % length
        new_tail = head        
        for i in range(length-k-1):
            new_tail = new_tail.next

        tail.next = head
        head = new_tail.next
        new_tail.next = None

        return head
            

