class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {

        var isFirstRowZero = false
        for(r in matrix.indices) {
            for (c in matrix[r].indices) {
                if (matrix[r][c] == 0) {
                    if (r == 0) isFirstRowZero = true
                    else matrix[r][0] = 0

                    matrix[0][c] = 0
                }
            }
        }

        for(r in matrix.size - 1 downTo 0) {
            for(c in matrix[r].size - 1 downTo 0) {
                if (r == 0 && isFirstRowZero) matrix[r][c] = 0
                if (r != 0 && (matrix[r][0] == 0 || matrix[0][c] == 0)) {
                    matrix[r][c] = 0
                }
            }
        }
    }
}