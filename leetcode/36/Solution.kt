class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val colSet: Array<HashSet<Char>> = Array(9) { HashSet<Char>() }
        for(row in board) {
            val rowSet = HashSet<Char>()

            for(i in row.indices) {
                val el = row[i]
                if (el == '.') continue

                if (el < '0' || el > '9') return false
                if (rowSet.contains(el)) return false
                if (colSet[i].contains(el)) return false

                rowSet.add(el)
                colSet[i].add(el)
            }
        }

        for(sr in 0..6 step 3) {
            for(sc in 0..6 step 3) {
                val rectSet = HashSet<Char>()
                for(r in sr until  sr + 3) {
                    for(c in sc until sc + 3) {
                        val ch = board[r][c]

                        if (ch == '.') continue
                        if (ch < '0' || ch > '9') return false
                        if (rectSet.contains(ch)) return false

                        rectSet.add(ch)
                    }
                }
            }
        }

        return true
    }
}