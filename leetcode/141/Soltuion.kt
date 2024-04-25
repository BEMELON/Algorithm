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
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false

        var curr = head!!
        while (curr.next != null) {
            if (curr.`val` == Int.MAX_VALUE) return true
            else curr.`val` = Int.MAX_VALUE

            curr = curr.next!!
        }

        return false
    }
}