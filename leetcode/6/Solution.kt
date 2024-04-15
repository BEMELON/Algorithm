import java.util.HashMap
import java.util.ArrayList

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (s.length == 1 || numRows == 1) return s

        val sb = StringBuilder()
        val map = HashMap<Int, ArrayList<Char>>()
        for(i in 0 until numRows) map[i] = ArrayList<Char>()

        return with (sb) {
            var i = 0
            val unit = numRows + (numRows - 2)

            while (i < s.length) {
                val pos = i % unit

                if (pos < numRows)  map[pos]?.add(s[i])
                else map[(numRows - 2) - (pos - numRows)]?.add(s[i])

                i++
            }

            for (idx in 0 until numRows) {
                for(ch in map[idx]!!)
                    append(ch)
            }

            toString()
        }

    }
}