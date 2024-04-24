class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.size == 1) return 1

        val sorted = points.sortedWith(compareBy({ it[0] }, { it[1] }))

        var count = 1
        var (start, end) = sorted[0]
        for (point in sorted.drop(1)) {
            if (start <= point[0] && point[0] <= end) {
                start = Math.max(start, point[0])
                end = Math.min(end, point[1])
            } else {
                count++
                start = point[0]
                end = point[1]
            }
        }

        return count
    }
}