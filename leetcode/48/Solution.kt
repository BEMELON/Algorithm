import kotlin.math.ceil

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        if (n == 1) return

        for (sr in 0..<ceil((n / 2.0)).toInt()) {
            val sc = sr
            for (col in sc until n - sc - 1) {
                var (r, c) = Pair(sr, col)
                var prev = matrix[r][c]

                for (i in 0 until 4) {
                    val (nx, ny) = getNext(r, c, n)

                    val temp = matrix[nx][ny]
                    matrix[nx][ny] = prev
                    prev = temp
                    r = nx
                    c = ny

                }
            }
        }
    }

    private fun getNext(r: Int, c: Int, n: Int): Pair<Int, Int> {
        return Pair(c, n - r - 1)
    }
}
