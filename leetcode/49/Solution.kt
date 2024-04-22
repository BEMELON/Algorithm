class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val answer = HashMap<Map<Char, Int>, ArrayList<String>>()

        for(str in strs) {
            val count = str.groupingBy { it }.eachCount()

            if (answer.containsKey(count)) {
                answer[count]?.add(str)
            } else {
                answer[count] = arrayListOf(str)
            }
        }

        return answer.values.toList()
    }
}