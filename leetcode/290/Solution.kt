class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {

        val map = HashMap<String, Char>()
        val reverseMap = HashMap<Char, String>()

        val words = s.split(" ")
        if (words.size != pattern.length) return false

        for (i in words.indices) {
            val (word, ch) = Pair(words[i], pattern[i])

            if (map.containsKey(word) != reverseMap.containsKey(ch)) return false

            if (!map.containsKey(word)) {
                map[word] = ch
                reverseMap[ch] = word
            } else if (map[word] != ch || word != reverseMap[ch]) return false;

            println(map)
            println(reverseMap)
        }

        return true
    }
}