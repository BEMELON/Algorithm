class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        nodes = [] 
        curr = head
        while curr:
            nodes.append(curr)
            curr = curr.next 
        
        if n == len(nodes): # Case 1) 맨 앞의 노드를 지우는 경우 
            head = head.next 
        else: # Case 2) else 
            prev = nodes[len(nodes) - (n + 1)]
            prev.next = prev.next.next
        return head
