class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sorted = nums.sorted()
        val result = ArrayList<ArrayList<Int>>()

        for(i in sorted.indices) {
            val fix = sorted[i]
            var (left, right) = Pair(i + 1, sorted.size - 1)

            while (left < right) {
                val sum = (sorted[left] + sorted[right] + fix)

                if (sum == 0) {
                    result.add(arrayListOf(fix, sorted[left], sorted[right]))
                    left++
                    right--
                } else if (sum < 0) {
                    left++
                } else {
                    right--
                }
            }
        }

        return result.distinct()
    }
}