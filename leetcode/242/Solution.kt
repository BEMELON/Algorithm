class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val count = s.groupingBy { it }.eachCount().toMutableMap()

        for(ch in t) {
            if (!count.containsKey(ch)) return false
            if (count[ch]!! <= 0)  return false
            count[ch] = count[ch]!! - 1
        }

        return true
    }
}