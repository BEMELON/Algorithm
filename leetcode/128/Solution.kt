class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.groupBy { it }.mapValues { 0 }.toMutableMap()

        // 1. 시작점 표시
        val startPoints = HashSet<Int>()

        for(num in nums) {
            if (!numSet.containsKey(num - 1)) {
                startPoints.add(num)
            }
        }

        println(startPoints)
        // 2. 시작점으로부터 최장 거리 계산
        var maxLen = 0
        for(start in startPoints) {
            var len = 0
            var i = start
            while (numSet.containsKey(i)) {
                len++

                i++
            }

            maxLen = Math.max(maxLen, len)
        }

        return maxLen
    }
}