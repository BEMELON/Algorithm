class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0

        val letters = HashMap<Char, Int>()

        var left = 0
        letters.put(s[left], 0)

        var maxLength = 1
        for (i in 1 until s.length) {
            val next = s[i]

            if (letters.contains(next)) {
                if (s[left] == next) {
                    // abca -> bca로 window 변경
                    letters.put(next, i)
                    left++
                } else {
                    left = letters[next]!! + 1

                    letters.clear()

                    for(j in left..i)
                        letters.put(s[j], j)

                }
            } else {
                maxLength = Math.max(maxLength, i - left + 1)
                letters.put(next, i)
            }

        }

        return maxLength
    }
}