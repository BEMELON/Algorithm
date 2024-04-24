import java.util.ArrayDeque

class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()

        val words = path.split("/")
        for(word in words.drop(1)) {
            if (word == ".." ) {
                if (stack.isNotEmpty())
                    stack.pollLast()
            } else if (word != "" && word != ".") {
                stack.add(word)
            }
s        }

        val sb = StringBuilder()
        return with (sb) {
            sb.append("/")
            while (stack.isNotEmpty()) {
                sb.append(stack.pollFirst())
                if (stack.isNotEmpty())
                    sb.append("/")
            }

            toString()
        }


    }
}