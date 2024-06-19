class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        else if (nums.size == 2) return Math.max(nums[0], nums[1])
        val dp = IntArray(nums.size)

        dp[0] = nums[0]
        dp[1] = Math.max(nums[0], nums[1])

        for (i in 2 until nums.size) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
        }

        return Math.max(dp[nums.size - 1], dp[nums.size - 2])
    }
}