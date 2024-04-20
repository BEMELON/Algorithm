
class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        // 5 -> 현재 살아 있음, 다음 턴에 죽음
        // 3 -> 현재 살아 있음, 다음 턴에 살음
        // 2 -> 현재 죽어 있음, 다음 턴에 죽음
        // 4 -> 현재 죽어 있음, 다음 턴에 살음

        val (m, n) = Pair(board.size, board[0].size)
        val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dy = intArrayOf(-1, 0, 1, -1, 1, -1 ,0, 1)

        for(r in board.indices) {
            for(c in board[r].indices) {
                var aliveCnt = 0

                for (d in dx.indices) {
                    val (nx, ny) = Pair(r + dx[d], c + dy[d])

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue
                    if (board[nx][ny] % 2 == 1) aliveCnt++
                }

                if (board[r][c] == 0) {
                    if (aliveCnt == 3) {
                        board[r][c] = 4
                    } else {
                        board[r][c] = 2
                    }
                } else if (board[r][c] == 1) {
                    if (aliveCnt < 2) board[r][c] = 5
                    else if (aliveCnt < 4) board[r][c] = 3
                    else board[r][c] = 5
                }

            }
        }

        for(r in board.indices) {
            for(c in board[r].indices) {
                when (board[r][c]) {
                    2 -> board[r][c] = 0
                    3 -> board[r][c] = 1
                    4 -> board[r][c] = 1
                    5 -> board[r][c] = 0
                }
            }
        }
    }
}