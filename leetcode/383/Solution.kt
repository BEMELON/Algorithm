class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        // Make a mutable map of characters in magazine and their count
        val count = magazine.groupingBy { it }.eachCount().toMutableMap()
        for(ch in ransomNote) {
            if (!count.containsKey(ch)) return false
            else if (count[ch]!! <= 0) return false

            count[ch] = count[ch]!! - 1
        }

        return true
    }

}