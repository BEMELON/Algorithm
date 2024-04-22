class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.size == 0) return arrayListOf()
        else if (nums.size == 1) return arrayListOf(nums[0].toString())

        val answer = ArrayList<String>()
        var (left, right) = Pair(0, 1)

        while (right < nums.size) {
            if (nums[right] - nums[left] != right - left) {
                if (left + 1 == right) {
                    answer.add(nums[left].toString())
                } else {
                    answer.add("${nums[left]}->${nums[right - 1]}")
                }
                left = right
                right += 1
            } else {
                right++
            }

        }

        if (left + 1 == nums.size) {
            answer.add(nums[left].toString())
        } else {
            answer.add("${nums[left]}->${nums[nums.size - 1]}")
        }

        return answer
    }
}