from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:  
        dummy = curr = ListNode()
        dummy.next = head
        while curr:
            runner = curr.next
            while runner and runner.next and runner.val == runner.next.val:
                runner = runner.next
            if curr.next is runner:
                curr = curr.next
            else:
                curr.next = runner.next

        return dummy.next

        