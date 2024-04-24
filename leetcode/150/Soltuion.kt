import java.util.Stack

class Solution {
    val ops =
        mapOf<String, (Int, Int) -> Int>("+" to Int::plus, "-" to Int::minus, "*" to Int::times, "/" to Int::div)

    fun evalRPN(tokens: Array<String>): Int =
        tokens.fold(Stack<Int>()) { stack, token ->
            with(stack) { push(ops[token]?.let { with(pop()) { it(pop(), this) } } ?: token.toInt()); this }
        }.pop()

}