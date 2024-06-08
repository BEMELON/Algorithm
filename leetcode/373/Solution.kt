import java.util.PriorityQueue

data class Pair(
    val x: Int, val y: Int
)

class Solution {
    val dx = listOf(0, 1)
    val dy = listOf(1, 0)

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val visited = HashSet<Pair>()

        val answer = ArrayList<List<Int>>()
        val pq = PriorityQueue<Pair>{ a, b -> (nums1[a.x] + nums2[a.y]) - (nums1[b.x] + nums2[b.y]) }
        visited.add(Pair(0, 0))
        pq.add(Pair(0, 0))

        for (unused in 0 until k) {
            val curr = pq.poll()

            // 뽑은 값은 최소 SUM인 것이 보장되니 정답에 삽입
            answer.add(listOf(nums1[curr.x], nums2[curr.y]))

            // 1. 뽑은 값의 다음 요소를 pq에 넣음
            for (i in 0 until 2) {
                val nx = curr.x + dx[i]
                val ny = curr.y + dy[i]
                val next = Pair(nx, ny)

                if (nx >= nums1.size || ny >= nums2.size) continue
                if (visited.contains(next)) continue

                pq.add(next)
                visited.add(next)
            }
        }

        return answer
     }
}
