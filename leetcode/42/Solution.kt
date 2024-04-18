class Solution {
    fun trap(height: IntArray): Int {
        if (height.size == 1) return 0

        var (left, right) = Pair(0, height.size - 1)
        var (leftMax, rightMax) = Pair(height[left], height[right])

        var result = 0
        while (left < right) {
            leftMax = Math.max(leftMax, height[left])
            rightMax = Math.max(rightMax, height[right])

            if (leftMax < rightMax) {
                result += (leftMax - height[left])
                left++
            } else {
                result += (rightMax - height[right])
                right--
            }
        }

        return result
    }
}