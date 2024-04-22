class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val sorted = intervals.sortedWith(compareBy({ it[0] }, { it[1] }))
        val result = ArrayList<IntArray>()
        var (start, end) = sorted[0]
        for(arr in sorted) {
            if (arr[0] > end) {
                result.add(intArrayOf(start, end))

                start = arr[0]
                end = arr[1]
            } else {
                end = Math.max(end, arr[1])
            }
        }

        result.add(intArrayOf(start, end))

        return result.toArray(arrayOf<IntArray>())
    }
}