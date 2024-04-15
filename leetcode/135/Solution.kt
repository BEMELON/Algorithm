class Solution {
    fun candy(ratings: IntArray): Int {
        if (ratings.size == 1) return 1

        val arr = IntArray(ratings.size)
        arr.fill(1)

        for(i in 0 until ratings.size - 1) {
            if (ratings[i] < ratings[i + 1] && arr[i + 1] <= arr[i]) {
                arr[i + 1] = arr[i] + 1
            }
        }

        for(i in ratings.size - 1 downTo 1) {
            if (ratings[i] < ratings[i - 1] && arr[i - 1] <= arr[i]) {
                arr[i - 1] = arr[i] + 1
            }
        }

        return arr.sum()
    }
}