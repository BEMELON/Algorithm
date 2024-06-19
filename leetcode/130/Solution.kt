class Solution {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    var m: Int = 0
    var n: Int = 0

    fun solve(board: Array<CharArray>): Unit {
        m = board.size
        n = board[0].size

        for (i in 0 until m) {
            if (board[i][0] == 'O') dfs(board, i, 0)
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1)
        }

        for (j in 0 until n) {
            if (board[0][j] == 'O') dfs(board, 0, j)
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j)
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'
                }
            }
        }
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return
        }
        board[i][j] = 'T'
        for (k in 0 until 4) {
            val x = i + dx[k]
            val y = j + dy[k]
            dfs(board, x, y)
        }
    }
}

fun main() {
    val solution = Solution()
    // [["O","X","O","O","O","X"],["O","O","X","X","X","O"],["X","X","X","X","X","O"],["O","O","O","O","X","X"],["X","X","O","O","X","O"],["O","O","X","X","X","X"]]
    val input = Array(6) { CharArray(6) }
    input[0] = charArrayOf('O', 'X', 'O', 'O', 'O', 'X')
    input[1] = charArrayOf('O', 'O', 'X', 'X', 'X', 'O')
    input[2] = charArrayOf('X', 'X', 'X', 'X', 'X', 'O')
    input[3] = charArrayOf('O', 'O', 'O', 'O', 'X', 'X')
    input[4] = charArrayOf('X', 'X', 'O', 'O', 'X', 'O')
    input[5] = charArrayOf('O', 'O', 'X', 'X', 'X', 'X')
    solution.solve(input)

}