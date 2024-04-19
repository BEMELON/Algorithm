class Solution {
    private var r: Int = 0
    private var c: Int = 0
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        r = matrix.size
        c = matrix[0].size

        val max = r * c
        val (dx, dy) = arrayOf(intArrayOf(0, 1, 0, -1), intArrayOf(1, 0, -1, 0))
        val answer = ArrayList<Int>()

        val visited = Array(matrix.size) { BooleanArray(matrix[0].size) }
        var count = 1

        var (r, c) = Pair(0, 0)
        while (count < max) {
            for(d in 0 until 4) {
                while (inRange(r, c)) {
                    visited[r][c] = true
                    val (nx, ny) = Pair(r + dx[d], c + dy[d])

                    if (!inRange(nx ,ny) || visited[nx][ny]) break
                    answer.add(matrix[r][c])
                    r = nx
                    c = ny

                    count++
                }
            }
        }

        answer.add(matrix[r][c])
        return answer
    }

    private fun inRange(nx: Int, ny: Int): Boolean {
        return nx in 0..<r && ny in 0..<c
    }

}
