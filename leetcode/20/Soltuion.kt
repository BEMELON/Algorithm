import java.util.Stack

class Solution {
    fun transpose(ch: Char): Char {
        return when (ch) {
            ')' -> '('
            '}' -> '{'
            ']' -> '['
            else -> '-'
        }
    }
    fun isValid(str: String): Boolean {
        val stack = Stack<Char>()

        for (ch in str) {
            if (ch == ')' || ch == '}' || ch == ']') {
                if (!(stack.isNotEmpty() && stack.pop() == transpose(ch))) return false
            } else {
                stack.add(ch)
            }
        }

        return stack.isEmpty()
    }
}