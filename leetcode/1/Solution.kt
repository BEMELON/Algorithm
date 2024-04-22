class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for(i in nums.indices) {
            val x = target - nums[i]
            if (map.containsKey(x)) {
                return intArrayOf(i, map[x]!!)
            } else {
                map[nums[i]] = i
            }
        }

        return intArrayOf(-1, -1)
    }
}