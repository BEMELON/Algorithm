class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        // Hash의 값을 Key로 하는 HashMap 을 하나 만들고 이어가는 형식
        val map = HashMap<Node, Node?>()

        var current = node
        while (current != null) {
            val copy = Node(current.`val`)

            map[current] = copy
            current = current.next
        }

        current = node
        while (current != null) {
            val copy = map[current]!!

            copy.next = map[current.next]
            copy.random = map[current.random]
            current = current.next
        }

        return map[node]!!
    }
}