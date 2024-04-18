class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0


        var answer = Int.MAX_VALUE
        for(i in nums.indices) {
            sum += nums[i]

            while (sum >= target) {
                answer = Math.min(answer, i - left + 1)
                sum -= nums[left++]
            }
        }


        return if (answer == Int.MAX_VALUE) 0 else answer
    }
}