class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = ArrayList<IntArray>()

        // 어차피 겹치는 구간은 Merge가 되어서 왔을 것이기 때문에
        var i = 0
        // 1. interval[i][1] < newInterval[0]

        while (i < intervals.size && intervals[i][1] < newInterval[0])
            result.add(intervals[i++])

        // 2. interval[i][0] < newInterval[1]
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0])
            newInterval[1] = Math.max(newInterval[1], intervals[i][1])
            i++
        }
        result.add(newInterval)

        // 3. else
        while (i < intervals.size) result.add(intervals[i++])


        return result.toTypedArray()
    }
}
