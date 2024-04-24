import java.util.Stack

data class Node(val min: Int, val n: Int)

class Solution {
    private val stack = Stack<Node>()

    fun push(n: Int) {
        if (stack.isEmpty()) {
            stack.push(Node(n, n))
        } else {
            stack.push(Node(Math.min(n, stack.peek().min), n))
        }
    }

    fun pop() {
        stack.pop().n
    }

    fun top(): Int {
        return stack.peek().n
    }

    fun getMin(): Int {
        return stack.peek().min
    }

}
