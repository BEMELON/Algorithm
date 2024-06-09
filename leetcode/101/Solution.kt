class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        return sym(root?.left, root?.right)
    }

    fun sym(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null && node2 == null) {
            return true
        }
        if (node1 == null || node2 == null) {
            return false
        }

        if (node1.`val` != node2.`val`) {
            return false
        }

        return sym(node1.left, node2.right) && sym(node1.right, node2.left)
    }
}