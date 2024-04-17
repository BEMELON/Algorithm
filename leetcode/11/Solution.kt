
class Solution {
    fun maxArea(height: IntArray): Int {
        var (left, right) = Pair(0, height.size - 1)


        var maxArea = 0
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]))

            if (height[right] > height[left]) {
                left++
            } else if (height[right] < height[left]) {
                right--
            } else {
                left++
                right--
            }
        }

        return maxArea
    }
}