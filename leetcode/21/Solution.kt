/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null && list2 == null) return null
        else if (list1 == null) return list2
        else if (list2 == null) return list1


        var head: ListNode? = null
        var tail: ListNode? = null
        var left: ListNode? = list1
        var right: ListNode? = list2

        while (left != null && right != null) {
            val temp = if (left.`val` > right.`val`) ListNode(right.`val`) else ListNode(left.`val`)

            if (head == null) {
                head = temp
                tail = temp
            } else {
                tail?.next = temp
                tail = temp
            }

            if (left.`val` > right.`val`) right = right.next
            else left = left.next

        }

        while (left != null) {
            val temp = ListNode(left.`val`)
            tail?.next = temp
            tail = temp

            left = left.next
        }

        while (right != null) {
            val temp = ListNode(right.`val`)
            tail?.next = temp
            tail = temp

            right = right.next
        }

        return head
    }
}