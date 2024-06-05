class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null|| root.left == null && root.right == null) return root

        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)

        return root
    }
}