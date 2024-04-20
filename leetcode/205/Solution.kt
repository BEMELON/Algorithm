class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val visited = HashSet<Char>()
        val transposeMap = HashMap<Char, Char>()

        for (i in s.indices) {
            val (src, target) = Pair(s[i], t[i])

            if (transposeMap.containsKey(src)) {
                if (transposeMap[src] != target) return false
            } else {
                if (visited.contains(target)) return false

                visited.add(target)
                transposeMap[src] = target
            }

        }
        return true
    }
}