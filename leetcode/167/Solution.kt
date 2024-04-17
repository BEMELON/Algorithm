
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var (left, right) = Pair(0, numbers.size - 1)

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return intArrayOf(left + 1, right + 1)
            } else if (numbers[left] + numbers[right] < target) {
                left++
            } else {
                right--
            }
        }

        return intArrayOf()
    }

}