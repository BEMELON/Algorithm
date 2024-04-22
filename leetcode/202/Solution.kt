class Solution {
    fun isHappy(n: Int): Boolean {
        val visited = HashSet<Int>()

        var x = n
        while (x != 1) {
            visited.add(x)

            val next = getNext(x)
            println("$x -> $next")
            if (visited.contains(next)) return false

            x = next
        }

        return true
    }

    private fun getNext(x: Int): Int {
        var next = 0

        var n = x
        while (n > 0) {
            next += (Math.pow(n % 10.0, 2.0)).toInt()
            n /= 10
        }

        return next
    }
}