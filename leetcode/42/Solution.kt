class Solution {
    fun trap(height: IntArray): Int {
        val leftMaxHeight = IntArray(height.size)
        val rightMaxHeight = IntArray(height.size)


        leftMaxHeight[0] = height[0]
        for (i in 1 until height.size) {
            leftMaxHeight[i] = Math.max(height[i], leftMaxHeight[i - 1])
        }

        rightMaxHeight[height.size - 1] = height.last()
        for (i in height.size - 2 downTo 0) {
            rightMaxHeight[i] = Math.max(height[i], rightMaxHeight[i + 1])
        }

        var result = 0
        for (i in 1 until height.size - 1) {
            result += Math.max(0, Math.min(leftMaxHeight[i - 1], rightMaxHeight[i + 1]) - height[i])
        }

        return result
    }
}